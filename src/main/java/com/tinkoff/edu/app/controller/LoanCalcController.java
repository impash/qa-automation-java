package com.tinkoff.edu.app.controller;

import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.service.LoanCalcService;

/**
 *Controller
 */
public class LoanCalcController {
    /**
     * Validates and logs request
     */
    public static int createRequest() {
        LoanCalcLogger.info("INFO: LoanCalcController.createRequest done");
        return LoanCalcService.createRequest();
    }
}
