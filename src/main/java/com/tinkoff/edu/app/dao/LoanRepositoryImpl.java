package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultType;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.Arrays;
import java.util.UUID;

public class LoanRepositoryImpl implements LoanCalcRepository{
    UUID uuid;
    final private LoanRequestRecord[] loanRequestRecords = new LoanRequestRecord[100_000];

    @Override
    public LoanRequestRecord save(LoanRequest loanRequest, LoanResultType status) {
        loanRequestRecords[0].setLoanType(loanRequest.getType());
        loanRequestRecords[0].setFio(loanRequest.getFio());
        loanRequestRecords[0].setAmount(loanRequest.getAmount());
        loanRequestRecords[0].setMonths(loanRequest.getMonths());
        loanRequestRecords[0].setUuid(uuid);
        loanRequestRecords[0].setMonths(loanRequest.getMonths());
        return loanRequestRecords[0];
    }

    @Override
    public LoanRequestRecord getRecordByUuid(UUID uuid) {
        LoanRequestRecord record = null;
        for (LoanRequestRecord loanRequestRecord : loanRequestRecords) {
            if (loanRequestRecord.getUuid() == uuid) {
                return loanRequestRecord;
            }
            record = loanRequestRecord;
        }
        return record;
    }

    //TODO
    public void changeStatus(UUID uuid, LoanResultType status) {

    }





//
//    public LoanRepositoryImpl(int requestId) {
//        this.requestId = requestId;
//    }
//
//    public LoanRepositoryImpl() {
//        this(0);
//    }
//
//    public int getRequestId() {
//        return requestId;
//    }
//
//    public LoanRequest getLoanRequests(String uuid) {
//        for (int i = 0; i < loanRequests.length; i++) {
//                if (loanRequests[i].getUuid().equals(uuid)){
//                   number = i;
//                   break;
//                }
//        }
//        return loanRequests[number];
//    }

}

