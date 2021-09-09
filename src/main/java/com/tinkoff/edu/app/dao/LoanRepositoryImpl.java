package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public class LoanRepositoryImpl implements LoanCalcRepository {
    private int count = 0;
    final private LoanRequestRecord[] loanRequestRecords = new LoanRequestRecord[100];

    @Override
    public LoanRequestRecord save(LoanRequest loanRequest, LoanResultStatus status) {
        loanRequestRecords[count] = new LoanRequestRecord();
        loanRequestRecords[count].setLoanType(loanRequest.getType());
        loanRequestRecords[count].setFio(loanRequest.getFio());
        loanRequestRecords[count].setAmount(loanRequest.getAmount());
        loanRequestRecords[count].setMonths(loanRequest.getMonths());
        loanRequestRecords[count].setUuid(UUID.randomUUID());
        loanRequestRecords[count].setStatus(status);
        count++;
        return loanRequestRecords[count-1];
    }

    @Override
    public LoanRequestRecord getRecordByUuid(UUID uuid) {
        for (LoanRequestRecord loanRequestRecord : loanRequestRecords) {
            if ((loanRequestRecord != null) && (loanRequestRecord.getUuid().equals(uuid))) {
                return loanRequestRecord;
            }
        }
        throw new IllegalStateException("Записей с переданным id не найдено");
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

