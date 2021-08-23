package com.tinkoff.edu.app.logger;

import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;

public class LoanCalcLogger {
    /**
     *our logs
     */
    public static void info(String message) {
        System.out.println(message);
    }

    public static void error(String message) {
        System.err.println(message);
    }

    public static void logObject(LoanRequest request) {
        System.out.println(request);
    }
    public static void logObject(LoanResponse request) {
        System.out.println(request);
    }
}
