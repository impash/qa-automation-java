package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.enums.LoanResultType;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

import java.util.Random;

public class LoanCalcService implements LoanServiceInterface {
    LoanCalcRepository repo;

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * TODO Loan calculation
     * @return
     */

    @Override
    public LoanResponse createRequest(LoanRequest request) {
        LoanCalcLogger.info("INFO: LoanCalcService.createRequest done");
        int responseId = repo.save(request);
        if (request.getType().equals(LoanType.PERSON) & request.getAmount() <= 10_000 & request.getMonths() <= 12)
            return new LoanResponse(LoanResultType.APPROVED, responseId);
        else if (request.getType() == LoanType.PERSON & request.getAmount() > 10_000 & request.getMonths() > 12)
            return new LoanResponse(LoanResultType.DECLINED, responseId);
        else if (request.getType() == LoanType.OOO & request.getAmount() <= 10_000)
            return new LoanResponse(LoanResultType.DECLINED, responseId);
        else if (request.getType() == LoanType.OOO & request.getAmount() > 10_000 & request.getMonths() < 12)
            return new LoanResponse(LoanResultType.APPROVED, responseId);
        else if (request.getType() == LoanType.OOO & request.getAmount() > 10_000 & request.getMonths() >= 12)
            return new LoanResponse(LoanResultType.DECLINED, responseId);
        else if (request.getType() == LoanType.IP)
            return new LoanResponse(LoanResultType.DECLINED, responseId);
        return new LoanResponse(LoanResultType.DECLINED, -1);
    }
}
