package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public interface LoanCalcRepository {
    void save(LoanRequest loanRequest, LoanResultStatus status, UUID uuid);
    LoanRequestRecord getRecordByUuid(UUID uuid);
    void changeStatus(UUID uuid, LoanResultStatus status);
}
