package com.tinkoff.edu.app.logger;

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
}
