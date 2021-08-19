package com.tinkoff.edu.app.controller;

import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.service.LoanCalcService;

/**
 * Controller
 */
public class LoanCalcController {
    /**
     * Validates and logs request
     */
    public LoanCalcController(LoanRequest request) {
        LoanCalcLogger.info("INFO: LoanCalcController.createRequest done");

    }
    public static int createRequest(LoanRequest request) { //formal
        //param validation
        //log request
        LoanCalcLogger.info("INFO: LoanCalcController.createRequest done");
        return LoanCalcService.createRequest(request);
    }
}
