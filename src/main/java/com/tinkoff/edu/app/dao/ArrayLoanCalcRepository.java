package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public class ArrayLoanCalcRepository implements LoanCalcRepository{
    private int requestId;
    int number;
    private LoanRequest[] loanRequests;

    public int save(LoanRequest request) {
        this.loanRequests[requestId+1] = request; //TODO fix id
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

    public LoanRequest getLoanRequests(String uuid) {
        for (int i = 0; i < loanRequests.length; i++) {
                if (loanRequests[i].getUuid().equals(uuid)){
                   number = i;
                   break;
                }
        }
        return loanRequests[number];
    }

}
