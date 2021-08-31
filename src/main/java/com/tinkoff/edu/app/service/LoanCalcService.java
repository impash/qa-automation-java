package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.enums.LoanResultType;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

import java.util.UUID;

public class LoanCalcService implements LoanServiceInterface {
    LoanCalcRepository repo;
    String uuid = UUID.randomUUID().toString();

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
        int responseId = repo.save(request);
        boolean startCondition = (request != null && request.getAmount() >= 1 && request.getMonths() >=1);
        if (startCondition && request.getType().equals(LoanType.PERSON) & request.getAmount() <= 10_000 & request.getMonths() <= 12)
            return new LoanResponse(LoanResultType.APPROVED, responseId, uuid);
        else if (startCondition && request.getType().equals(LoanType.PERSON) & request.getAmount() > 10_000 & request.getMonths() > 12)
            return new LoanResponse(LoanResultType.DECLINED, responseId, uuid);
        else if (startCondition && request.getType().equals(LoanType.OOO) & request.getAmount() <= 10_000)
            return new LoanResponse(LoanResultType.DECLINED, responseId, uuid);
        else if (startCondition && request.getType().equals(LoanType.OOO) & request.getAmount() > 10_000 & request.getMonths() < 12)
            return new LoanResponse(LoanResultType.APPROVED, responseId, uuid);
        else if (startCondition && request.getType().equals(LoanType.OOO) & request.getAmount() > 10_000 & request.getMonths() >= 12)
            return new LoanResponse(LoanResultType.DECLINED, responseId, uuid);
        else if (startCondition && request.getType().equals(LoanType.IP))
            return new LoanResponse(LoanResultType.DECLINED, responseId, uuid);
        return new LoanResponse(LoanResultType.DECLINED, -1, "-1");

//        switch () {
//            case (request.getType().equals(LoanType.PERSON) & request.getAmount() <= 10_000 & request.getMonths() <= 12):
//            case (request.getType().equals(LoanType.OOO) & request.getAmount() > 10_000 & request.getMonths() < 12):
//                return new LoanResponse(LoanResultType.APPROVED, responseId, uuid);
//            break;
//            case (request.getType().equals(LoanType.PERSON) & request.getAmount() > 10_000 & request.getMonths() > 12):
//            case (request.getType().equals(LoanType.OOO) & request.getAmount() <= 10_000):
//            case (request.getType().equals(LoanType.OOO) & request.getAmount() > 10_000 & request.getMonths() >= 12):
//            case (request.getType().equals(LoanType.IP)):
//                return new LoanResponse(LoanResultType.DECLINED, responseId, uuid);
//            break;
//            default:
//                return new LoanResponse(LoanResultType.DECLINED, -1, "-1");
//            break;
//        }
    }
}
