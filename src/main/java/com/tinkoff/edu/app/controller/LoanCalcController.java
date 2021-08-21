package com.tinkoff.edu.app.controller;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.service.IpNotFriendlyService;
import com.tinkoff.edu.app.service.LoanCalcService;

/**
 * Controller
 */
public class LoanCalcController {
    private LoanCalcService loanCalcService = new LoanCalcService(repo); //Creator

    public LoanCalcController(LoanCalcRepository repo) {
        loanCalcService = new IpNotFriendlyService(repo);
    }

    /**
     * Validates and logs request
     */

    public int createRequest(LoanRequest request) { //formal

        //param validation
        //log request
        LoanCalcLogger.info("INFO: LoanCalcController.createRequest done");
        return loanCalcService.createRequest(request);
    }
}
