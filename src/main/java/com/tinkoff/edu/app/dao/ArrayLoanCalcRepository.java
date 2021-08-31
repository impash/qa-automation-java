package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public class ArrayLoanCalcRepository implements LoanCalcRepository{
    private int requestId;
    private LoanRequest[] loanRequests;

    public int save(LoanRequest request) {
        this.loanRequests[requestId] = request;
        ++requestId;
        LoanCalcLogger.info("INFO: LoanCalcRepository.requestId = " + requestId);
        return this.requestId;
    }

    public ArrayLoanCalcRepository(int requestId) {
        this.requestId = requestId;
    }

    public ArrayLoanCalcRepository() {
        this(0);
    }

    public int getRequestId() {
        return requestId;
    }

    public LoanRequest[] getLoanRequests() {
        return loanRequests;
    }


}
