package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.enums.LoanUserType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

import java.util.UUID;

public class LoanCalcService implements LoanServiceInterface {
    LoanCalcRepository repo;

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * CreateNewLoanRequest
     * @param request
     * @return Выполняем новый запрос на кредит
     */

    @Override
    public LoanResponse createRequest(LoanRequest request) {
        if ((request.getFio().length() < 10) || (request.getFio().length() > 100)) {
            throw new IllegalArgumentException("- Поле ФИО должно содержать не менее 10 и не более 100 символов");
        }
        LoanResultStatus calcStatus = LoanResultStatus.DECLINED;
        switch (request.getType()){
            case PERSON: if (request.getAmount() <= 10_000 & request.getMonths() <= 12){
                calcStatus = LoanResultStatus.APPROVED;
            } break;
            case OOO: if(request.getAmount() > 10_000 & request.getMonths() < 12){
                calcStatus = LoanResultStatus.APPROVED;
            } break;
            case IP: break;
        }
        var newRecord = repo.save(request,calcStatus);
        return new LoanResponse(calcStatus, newRecord.getUuid());
    }

    /**
     * GetStatusByUser
     * @param uuid
     * @return Юзер запрашивает статус по своему uuid
     */
    public LoanResultStatus getStatus(UUID uuid) {
        try {
            LoanCalcLogger.info("\n- Выполняется запрос по UUID: " + uuid);
            var record = repo.getRecordByUuid(uuid);
            LoanCalcLogger.info("- Запрос выполнен");
            return record.getStatus();
        } catch (Exception e){
            throw e;
        }
    }

    /**
     * ChangeStatus
     * @param uuid
     * @param status
     */
    public void changeStatus(UUID uuid, LoanResultStatus status) {
        repo.changeStatus(uuid, status);
    }
}
