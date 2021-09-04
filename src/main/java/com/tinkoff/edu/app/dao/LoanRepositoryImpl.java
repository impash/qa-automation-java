package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public class LoanRepositoryImpl implements LoanCalcRepository {
    private int count = 0;
    final private LoanRequestRecord[] loanRequestRecords = new LoanRequestRecord[100];

    @Override
    public void save(LoanRequest loanRequest, LoanResultStatus status, UUID uuid) {
        loanRequestRecords[count] = new LoanRequestRecord();
        loanRequestRecords[count].setLoanType(loanRequest.getType());
        loanRequestRecords[count].setFio(loanRequest.getFio());
        loanRequestRecords[count].setAmount(loanRequest.getAmount());
        loanRequestRecords[count].setMonths(loanRequest.getMonths());
        loanRequestRecords[count].setUuid(uuid);
        loanRequestRecords[count].setStatus(status);
        count++;
    }

    @Override
    public LoanRequestRecord getRecordByUuid(UUID uuid) {
        int number = -1;
        for (int i = 0; i < loanRequestRecords.length; i++) {
            if ((loanRequestRecords[i] != null) && (loanRequestRecords[i].getUuid() == uuid)) {
                number = i;
                break;
            }
        }
        return loanRequestRecords[number];
    }

    @Override
    public void changeStatus(UUID uuid, LoanResultStatus status) {
        for (LoanRequestRecord loanRequestRecord : loanRequestRecords) {
            if ((loanRequestRecord != null) && (loanRequestRecord.getUuid() == uuid)) {
                loanRequestRecord.setStatus(status);
            }
        }
    }
}

