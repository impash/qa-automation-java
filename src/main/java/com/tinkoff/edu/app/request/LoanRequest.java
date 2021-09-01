package com.tinkoff.edu.app.request;

import com.tinkoff.edu.app.enums.LoanType;

import java.util.UUID;

/**
 * Class, Type -> objects, instances
 */
public class LoanRequest {
    private final LoanType type;
    private final int months; //stateful + immutable
    private final int amount;

    private final String uuid;

    private final String fio;
    public LoanRequest(LoanType type, int months, int amount, String fio, String uuid) {
        this.type = type;
        this.months = months;
        this.amount = amount;
        this.fio = fio;
        this.uuid = uuid;
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

    public String getFio() {
        return fio;
    }

    public String getUuid() {
        return uuid;
    }

    public String toString(){
        return "RQ: {"
                + this.type + ", "
                + this.getAmount() + " for "
                + this.getMonths() + " months from "
                + this.getFio() +
                "}";
    }
}