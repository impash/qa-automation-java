package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

public interface LoanServiceInterface {
    LoanResponse createRequest(LoanRequest request);
}
