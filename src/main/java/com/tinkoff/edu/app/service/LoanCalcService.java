package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.enums.LoanResultType;
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
        LoanResultType[] typeArray = LoanResultType.values();
        LoanResultType type = typeArray[new Random().nextInt(typeArray.length - 1)];

        return new LoanResponse(type, responseId);
    }
}
