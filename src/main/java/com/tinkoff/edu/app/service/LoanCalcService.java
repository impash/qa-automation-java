package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.logger.LoanCalcLogger;

public class LoanCalcService {
    /**
     * Loan calculation
     */
    public static int createRequest() {
        LoanCalcLogger.info("INFO: LoanCalcService.createRequest done");
        return LoanCalcRepository.save();
    }
}
