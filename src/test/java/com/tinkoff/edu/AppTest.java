package com.tinkoff.edu;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.dao.VariableLoanCalcRepository;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AppTest {
    LoanRequest loanRequest;
    VariableLoanCalcRepository variableLoanCalcRepository;
    int id;
    int expectedId;
    LoanResponse requestId;

    @BeforeEach
    public void init(){
        id = 2;
        expectedId = 1;
    }

    @Test
    public void shouldAnswerWithValue1() {
        loanRequest = new LoanRequest(LoanType.IP, 10,1_000);
        VariableLoanCalcRepository repo = new VariableLoanCalcRepository();
        LoanCalcController loanCalcController = new LoanCalcController(repo);
        requestId = loanCalcController.createRequest(loanRequest);
        assumeTrue(repo.getRequestId() == 0);
        LoanCalcLogger.logObject(requestId);
        assertEquals(expectedId, requestId.getRequestId());
        LoanCalcLogger.info("INFO: Test succeeded");
    }

    @Test
    public void shouldAnswerWithAnyValue() {
        final int DEFAULT_ANY_ID = 1;
        loanRequest = new LoanRequest(LoanType.IP, 10,1_000);
        LoanCalcController loanCalcController = new LoanCalcController(new VariableLoanCalcRepository(DEFAULT_ANY_ID));
        requestId = loanCalcController.createRequest(loanRequest);
//        LoanCalcLogger.logObject(requestId);
        assertEquals(id, requestId.getRequestId());
//        LoanCalcLogger.info("INFO: Test succeeded");
    }
}
