package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultType;
import com.tinkoff.edu.app.enums.LoanType;

import java.util.UUID;

public class LoanRequestRecord {
    private int amount;
    private int months;
    private UUID uuid;
    private String fio;
    private LoanResultType status;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LoanResultType getStatus() {
        return status;
    }

    public void setStatus(LoanResultType status) {
        this.status = status;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    private LoanType loanType;

}
