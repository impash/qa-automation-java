package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultType;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public interface LoanCalcRepository {
    LoanRequestRecord save(LoanRequest loanRequest, LoanResultType status);
    LoanRequestRecord getRecordByUuid(UUID uuid);
}
