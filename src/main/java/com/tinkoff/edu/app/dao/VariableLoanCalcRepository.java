package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;

public class VariableLoanCalcRepository implements LoanCalcRepository{
    private int requestId;

    public VariableLoanCalcRepository(int requestId) {
        this.requestId = requestId;
    }

    public VariableLoanCalcRepository() {
        this(0);
    }

    public int getRequestId() {
        return requestId;
    }

    /**
     * TODO persists request
     * @return RequestId
     * @param request
     */
    public int save(LoanRequest request) {
        ++requestId;
        LoanCalcLogger.info("INFO: LoanCalcRepository.requestId = " + requestId);
        return this.requestId;
    }
}
