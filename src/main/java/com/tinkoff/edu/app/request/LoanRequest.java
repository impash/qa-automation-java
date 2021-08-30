package com.tinkoff.edu.app.request;

import com.tinkoff.edu.app.enums.LoanType;

/**
 * Class, Type -> objects, instances
 */
public class LoanRequest {
    private final LoanType type;
    private final int months; //stateful + immutable
    private final int amount;

    public LoanRequest(LoanType type, int months, int amount) {
        this.type = type;
        this.months = months;
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public LoanType getType() {
        return type;
    }

    public String toString(){
        return "RQ: {"
                + this.type + ", "
                + this.getAmount() + " for "
                + this.getMonths() +
                "}";
    }
}