package com.tinkoff.edu.app;

/**
 *Controller
 */
public class LoanCalcController {
    /**
     * Validates and logs request
     */
    public static int createRequest() {
        LoanCalcLogger.log();
        return LoanCalcService.createRequest();
    }
}
