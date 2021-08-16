package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.logger.LoanCalcLogger;

public class LoanCalcRepository {
    private static int requestId;
    /**
     * TODO persists request
     * @return RequestId
     */
    public static int save() {
        int result = ++requestId;
        LoanCalcLogger.info("INFO: LoanCalcRepository.requestId = " + result);
        return result;
    }
}
