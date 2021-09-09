package com.tinkoff.edu.app.controller;

import com.tinkoff.edu.app.dao.LoanRepositoryImpl;
import com.tinkoff.edu.app.dao.LoanRequestRecord;
import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;
import com.tinkoff.edu.app.service.LoanCalcService;
import com.tinkoff.edu.app.service.LoanServiceInterface;

import java.util.UUID;

/**
 * Controller
 */
public class LoanCalcController {
    LoanServiceInterface loanCalcService = new LoanCalcService(new LoanRepositoryImpl());

    /**
     * createRequest
     * @return
     */
    public LoanResponse createRequest(LoanRequest request) {
        LoanCalcLogger.logObject(request);
        return loanCalcService.createRequest(request);
    }

    /**
     * getStatus
     * @param uuid
     * @return
     */
    public LoanRequestRecord getStatus(UUID uuid) {
        return loanCalcService.getStatus(uuid);
    }

    /**
     * changeStatus
     * @param uuid
     * @param status
     */
    public void changeStatus(UUID uuid, LoanResultStatus status){
        loanCalcService.changeStatus(uuid, status);
    }

}
