package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;

public class LoanCalcService {
    public LoanCalcService(LoanRequest request){

    }
    /**
     * TODO Loan calculation
     */
    public static int createRequest(LoanRequest request) {
        int localVar;

        LoanCalcLogger.info("INFO: LoanCalcService.createRequest done");
        return LoanCalcRepository.save();
    }
}
