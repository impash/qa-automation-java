package com.tinkoff.edu;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    LoanRequest loanRequest;
    LoanCalcController loanCalcController;
    LoanResponse requestId;

    @BeforeEach
    public void init(){
        loanRequest = new LoanRequest(LoanType.IP, 10,1_000);
        loanCalcController = new LoanCalcController();
        requestId = loanCalcController.createRequest(loanRequest);
    }

    @Test
    public void shouldAnswerWithOne() {
        LoanCalcLogger.logObject(requestId);
        int check = 1;
        Assertions.assertEquals(check, requestId.getRequestId());
        LoanCalcLogger.info("INFO: Test succeeded");
    }

    @Test
    public void shouldAnswerWithAnyValue() {
        LoanCalcLogger.logObject(requestId);
        int check = 1;
        Assertions.assertEquals(check, requestId.getRequestId());
        LoanCalcLogger.info("INFO: Test succeeded");
    }
}
