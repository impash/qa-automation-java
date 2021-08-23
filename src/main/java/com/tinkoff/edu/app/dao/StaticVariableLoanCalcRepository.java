package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;

public class StaticVariableLoanCalcRepository implements LoanCalcRepository{
    private static int requestId;
    /**
     * TODO persists request
     * @return RequestId
     * @param request
     */
    public int save(LoanRequest request) {
        ++requestId;
        LoanCalcLogger.info("INFO: LoanCalcRepository.requestId = " + requestId);
        return requestId;
    }
}
