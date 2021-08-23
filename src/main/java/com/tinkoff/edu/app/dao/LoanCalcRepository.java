package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.request.LoanRequest;

public interface LoanCalcRepository {
    int save(LoanRequest loanRequest);
}
