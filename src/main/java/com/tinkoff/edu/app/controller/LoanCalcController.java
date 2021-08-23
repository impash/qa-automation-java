package com.tinkoff.edu.app.controller;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.dao.StaticVariableLoanCalcRepository;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;
import com.tinkoff.edu.app.service.IpNotFriendlyService;
import com.tinkoff.edu.app.service.LoanServiceInterface;

/**
 * Controller
 */
public class LoanCalcController {
    LoanCalcRepository loanCalcRepository = new StaticVariableLoanCalcRepository();
    LoanServiceInterface loanCalcService = new IpNotFriendlyService(loanCalcRepository);

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
}
