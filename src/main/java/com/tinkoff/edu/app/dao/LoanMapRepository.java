package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoanMapRepository implements LoanRepositoryInterface {
    private final Map<UUID, LoanRequestRecord> mapRepo = new HashMap<>();

    @Override
    public LoanRequestRecord save(LoanRequest loanRequest, LoanResultStatus status) {
        UUID uuid = UUID.randomUUID();
        LoanRequestRecord record = new LoanRequestRecord();
        record.setFio(loanRequest.getFio());
        record.setUuid(uuid);
        record.setLoanType(loanRequest.getType());
        record.setAmount(loanRequest.getAmount());
        record.setMonths(loanRequest.getMonths());
        record.setStatus(status);
        mapRepo.put(uuid, record);
        return mapRepo.get(uuid);
    }

    @Override
    public LoanRequestRecord getRecordByUuid(UUID uuid) {
        LoanRequestRecord loanRequestRecord = mapRepo.get(uuid);
        if (loanRequestRecord != null) {
            return loanRequestRecord;
        }
        throw new IllegalStateException("- Записей с переданным id не найдено");
    }

    @Override
    public void changeStatus(UUID uuid, LoanResultStatus status) {
        getRecordByUuid(uuid).setStatus(status);
    }
}
