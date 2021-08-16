package com.tinkoff.edu.app;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.logger.LoanCalcLogger;

public class App {
    /**
     * Running test inside our app
     */
    public static void main(String[] args) {
        int requestId = LoanCalcController.createRequest();
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
    }
}
