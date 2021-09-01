package com.tinkoff.edu;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.dao.ArrayLoanCalcRepository;
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
    ArrayLoanCalcRepository repo;
    int id;
    int expectedId;
    LoanResponse requestId;
    String uuid;

    @BeforeEach
    public void init(){
        id = 2;
        expectedId = 1;
    }

//    @Test
//    public void shouldAnswerWithValue1() {
//        String fio = "bla bla bla";
//        loanRequest = new LoanRequest(LoanType.IP, 10,1_000, fio, "");
//        VariableLoanCalcRepository repo = new VariableLoanCalcRepository();
//        LoanCalcController loanCalcController = new LoanCalcController(repo);
//        requestId = loanCalcController.createRequest(loanRequest);
//        assumeTrue(repo.getRequestId() == 0);
//        LoanCalcLogger.logObject(requestId);
//        assertEquals(expectedId, requestId.getRequestId());
//        LoanCalcLogger.info("INFO: Test succeeded");
//    }
//
//    @Test
//    public void shouldAnswerWithAnyValue() {
//        final int DEFAULT_ANY_ID = 1;
//        String fio = "bla bla bla";
//        loanRequest = new LoanRequest(LoanType.IP, 10,1_000, fio, "");
//        LoanCalcController loanCalcController = new LoanCalcController(new VariableLoanCalcRepository(DEFAULT_ANY_ID));
//        requestId = loanCalcController.createRequest(loanRequest);
//        LoanCalcLogger.logObject(requestId);
//        assertEquals(id, requestId.getRequestId());
//        LoanCalcLogger.info("INFO: Test succeeded");
//    }
//
//    @Test
//    public void shouldGetErrorWhenApplyNullRequest() {
//        String fio = "bla bla bla";
//        loanRequest = null;
//        VariableLoanCalcRepository repo = new VariableLoanCalcRepository();
//        LoanCalcController loanCalcController = new LoanCalcController(repo);
//        requestId = loanCalcController.createRequest(loanRequest);
//        assumeTrue(repo.getRequestId() == 0);
//        LoanCalcLogger.logObject(requestId);
//        assertEquals(-1, requestId.getRequestId());
//        LoanCalcLogger.info("INFO: Test succeeded");
//    }
//
//    @Test
//    public void shouldGetErrorWhenApplyZeroAmountRequest() {
//        String fio = "bla bla bla";
//        loanRequest = new LoanRequest(LoanType.IP, 10,0, fio, "");
//        VariableLoanCalcRepository repo = new VariableLoanCalcRepository();
//        LoanCalcController loanCalcController = new LoanCalcController(repo);
//        requestId = loanCalcController.createRequest(loanRequest);
//        assumeTrue(repo.getRequestId() == 0);
//        LoanCalcLogger.logObject(requestId);
//        assertEquals(-1, requestId.getRequestId());
//    }
//
//    @Test
//    public void shouldGetErrorWhenApplyNegativeAmountRequest() {
//        String fio = "bla bla bla";
//        loanRequest = new LoanRequest(LoanType.IP, 10,-1, fio, "");
//        VariableLoanCalcRepository repo = new VariableLoanCalcRepository();
//        LoanCalcController loanCalcController = new LoanCalcController(repo);
//        requestId = loanCalcController.createRequest(loanRequest);
//        assumeTrue(repo.getRequestId() == 0);
//        LoanCalcLogger.logObject(requestId);
//        assertEquals(-1, requestId.getRequestId());
//    }

    @Test
    public void shouldGetLoanRequestForUser() {
        String fio = "bla bla bla";
        loanRequest = new LoanRequest(LoanType.IP, 10,-1, fio, uuid);
        repo = new ArrayLoanCalcRepository();
        LoanCalcController loanCalcController = new LoanCalcController(repo);
        requestId = loanCalcController.createRequest(loanRequest);
        assumeTrue(repo.getRequestId() == 0);
        LoanCalcLogger.logObject(requestId);
        assertEquals(-1, requestId.getRequestId());
        System.out.println(repo.getLoanRequests(uuid));
    }
}
