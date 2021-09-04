package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.dao.LoanRequestRecord;
import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.enums.LoanUserType;
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
        UUID uuid = UUID.randomUUID();
        if (request.getType().equals(LoanUserType.PERSON) & request.getAmount() <= 10_000 & request.getMonths() <= 12) {
            repo.save(request, LoanResultStatus.APPROVED, uuid);
            return new LoanResponse(LoanResultStatus.APPROVED, uuid);
        }
        else if (request.getType().equals(LoanUserType.PERSON) & request.getAmount() > 10_000 & request.getMonths() > 12) {
            repo.save(request, LoanResultStatus.DECLINED, uuid);
            return new LoanResponse(LoanResultStatus.DECLINED, uuid);
        }
        else if (request.getType().equals(LoanUserType.OOO) & request.getAmount() <= 10_000) {
            repo.save(request, LoanResultStatus.DECLINED, uuid);
            return new LoanResponse(LoanResultStatus.DECLINED, uuid);
        }
        else if (request.getType().equals(LoanUserType.OOO) & request.getAmount() > 10_000 & request.getMonths() < 12) {
            repo.save(request, LoanResultStatus.APPROVED, uuid);
            return new LoanResponse(LoanResultStatus.APPROVED, uuid);
        }
        else if (request.getType().equals(LoanUserType.OOO) & request.getAmount() > 10_000 & request.getMonths() >= 12) {
            repo.save(request, LoanResultStatus.DECLINED, uuid);
            return new LoanResponse(LoanResultStatus.DECLINED, uuid);
        }
        else if (request.getType().equals(LoanUserType.IP)) {
            repo.save(request, LoanResultStatus.DECLINED, uuid);
            return new LoanResponse(LoanResultStatus.DECLINED, uuid);
        }
        throw new IllegalArgumentException("-1");
    }

    /**
     * GetStatusByUser
     * @param uuid
     * @return Юзер запрашивает статус по своему uuid
     */
    public LoanRequestRecord getStatus(UUID uuid) {
        try {
            return repo.getRecordByUuid(uuid);
        } catch (IllegalArgumentException e){
            System.out.println("Вот такая вот хуйня, Андрюха..." + e);
        }
        return null;
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
