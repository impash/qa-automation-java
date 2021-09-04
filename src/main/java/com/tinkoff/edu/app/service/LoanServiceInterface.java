package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanRequestRecord;
import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

import java.util.UUID;

public interface LoanServiceInterface {
    LoanResponse createRequest(LoanRequest request);
    LoanRequestRecord getStatus(UUID uuid);
    void changeStatus(UUID uuid, LoanResultStatus status);
}
