package com.tinkoff.edu.app.controller;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.dao.LoanRepositoryImpl;
import com.tinkoff.edu.app.dao.LoanRequestRecord;
import com.tinkoff.edu.app.enums.LoanResultType;
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
    LoanRepositoryImpl repo = new LoanRepositoryImpl();
    LoanServiceInterface loanCalcService = new LoanCalcService(repo);


    public LoanCalcController() {
        this.repo = null;
    }

    /**
     * Validates and logs request
     * @return
     */
    public LoanResponse createRequest(LoanRequest request) { //formal
        //param validation
        //log request
        LoanCalcLogger.info("INFO: LoanCalcController.createRequest done");
        LoanCalcLogger.logObject(request);
        return loanCalcService.createRequest(request);
    }
    public LoanRequestRecord getStatus(UUID uuid){
       return repo.getRecordByUuid(uuid);
    }

    //TODO
//    public changeStatus(UUID uuid, LoanResultType loanResultType){
//        loanCalcService.(loanResultType);
//    }
}
