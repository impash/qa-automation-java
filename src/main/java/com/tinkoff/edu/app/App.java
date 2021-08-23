package com.tinkoff.edu.app;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.dao.StaticVariableLoanCalcRepository;
import com.tinkoff.edu.app.enums.LoanResultType;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

public class App {
    /**
     * Running test inside our app
     */
    public static void main(String[] args) {
        LoanRequest loanRequest = new LoanRequest(LoanType.IP, 10,1_000);
        LoanCalcController loanCalcController = new LoanCalcController();
        int requestId = loanCalcController.createRequest(loanRequest);
//        LoanResponse response = new LoanResponse(LoanResultType.DENIED, requestId);
        int check = 1;
        try {
            if (requestId != check) {
                throw new AssertionError("ERROR: requestId = " + requestId + " (не равно ожидаемому значению " + check + ")");
            }
        }
        catch (Throwable e) {
            LoanCalcLogger.error(e.getMessage());
            throw e;
        }
//        LoanCalcLogger.logObject(response);
        LoanCalcLogger.info("INFO: Test succeeded");
    }
}
