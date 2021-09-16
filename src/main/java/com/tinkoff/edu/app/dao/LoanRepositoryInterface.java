package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public interface LoanRepositoryInterface {
    LoanRequestRecord save(LoanRequest loanRequest, LoanResultStatus status);
    LoanRequestRecord getRecordByUuid(UUID uuid);
    void changeStatus(UUID uuid, LoanResultStatus status);
}
