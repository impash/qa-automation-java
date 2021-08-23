package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;

public class LoanCalcService implements LoanServiceInterface {
    LoanCalcRepository repo;

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * TODO Loan calculation
     */

    @Override
    public int createRequest(LoanRequest request) {
        LoanCalcLogger.info("INFO: LoanCalcService.createRequest done");
        return repo.save(request);
    }
}
