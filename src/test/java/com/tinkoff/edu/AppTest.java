package com.tinkoff.edu;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.dao.StaticVariableLoanCalcRepository;
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
    StaticVariableLoanCalcRepository staticVariableLoanCalcRepository;
    int id;
    int expectedId;
    LoanResponse requestId;

    @BeforeEach
    public void init(){
        id = 2;
        expectedId = 1;
        staticVariableLoanCalcRepository = new StaticVariableLoanCalcRepository();
        loanRequest = new LoanRequest(LoanType.IP, 10,1_000);
        loanCalcController = new LoanCalcController();
        requestId = loanCalcController.createRequest(loanRequest);
    }

    @Test
    public void shouldAnswerWithValue1() {
        LoanCalcLogger.logObject(requestId);
        Assertions.assertEquals(expectedId, requestId.getRequestId());
        LoanCalcLogger.info("INFO: Test succeeded");
    }

    @Test
    public void shouldAnswerWithAnyValue() {
        staticVariableLoanCalcRepository.setRequestId(id);
        LoanCalcLogger.logObject(requestId);
        Assertions.assertEquals(id, requestId.getRequestId());
        LoanCalcLogger.info("INFO: Test succeeded");
    }
}
