package com.tinkoff.edu.app.request;

import com.tinkoff.edu.app.enums.LoanUserType;

/**
 * Class, Type -> objects, instances
 */
public class LoanRequest {
    private final LoanUserType type;
    private final int months; //stateful + immutable
    private final int amount;

    private final String fio;
    public LoanRequest(LoanUserType type, int months, int amount, String fio) {
        this.type = type;
        this.months = months;
        this.amount = amount;
        this.fio = fio;
    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public LoanUserType getType() {
        return type;
    }

    public String getFio() {
        return fio;
    }

    public String toString(){
        return "RQ: {"
                + this.type + ", "
                + this.getAmount() + " for "
                + this.getMonths() + " months by "
                + this.getFio() +
                "}";
    }
}