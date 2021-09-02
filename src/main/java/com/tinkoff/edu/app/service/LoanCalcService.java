package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.dao.LoanRequestRecord;
import com.tinkoff.edu.app.enums.LoanResultType;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

import java.util.UUID;

public class LoanCalcService implements LoanServiceInterface {
    LoanCalcRepository repo;
    UUID uuid = UUID.randomUUID();
    LoanRequestRecord loanRequestRecord = repo.getRecordByUuid(uuid);

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * TODO Loan calculation
     *
     * @return
     */

    @Override
    public LoanResponse createRequest(LoanRequest request) {
        LoanCalcLogger.info("INFO: LoanCalcService.createRequest done");

        LoanResponse loanResponse;

        repo.save(request, loanRequestRecord.getStatus());
        boolean startCondition = (request != null && request.getAmount() >= 1 && request.getMonths() >=1);
        if (startCondition && request.getType().equals(LoanType.PERSON) & request.getAmount() <= 10_000 & request.getMonths() <= 12)
            return new LoanResponse(LoanResultType.APPROVED, uuid);
        else if (startCondition && request.getType().equals(LoanType.PERSON) & request.getAmount() > 10_000 & request.getMonths() > 12)
            return new LoanResponse(LoanResultType.DECLINED, uuid);
        else if (startCondition && request.getType().equals(LoanType.OOO) & request.getAmount() <= 10_000)
            return new LoanResponse(LoanResultType.DECLINED, uuid);
        else if (startCondition && request.getType().equals(LoanType.OOO) & request.getAmount() > 10_000 & request.getMonths() < 12)
            return new LoanResponse(LoanResultType.APPROVED, uuid);
        else if (startCondition && request.getType().equals(LoanType.OOO) & request.getAmount() > 10_000 & request.getMonths() >= 12)
            return new LoanResponse(LoanResultType.DECLINED, uuid);
        else if (startCondition && request.getType().equals(LoanType.IP))
            return new LoanResponse(LoanResultType.DECLINED, uuid);
        return new LoanResponse(LoanResultType.DECLINED, null);

        //TODO
//        LoanType type;
//        switch (type){
//            case IP: return LoanResultType.DECLINED; break;
//            default: switch (type){
//            case OOO: return
//            }
//        }
    }

    LoanRequestRecord getStatus(UUID uuid) {
        return repo.getRecordByUuid(uuid);
    }

    //TODO
//    changeStatus(UUID uuid, LoanResultType status) {
//
//        this.loanRequestRecord.setStatus(status);
//    }

}
