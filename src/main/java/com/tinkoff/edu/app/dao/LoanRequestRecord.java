package com.tinkoff.edu.app.dao;

import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.enums.LoanUserType;

import java.util.UUID;

public class LoanRequestRecord {
    private int amount;
    private int months;
    private UUID uuid;
    private String fio;
    private LoanResultStatus status;
    private LoanUserType loanUserType;

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

    public LoanResultStatus getStatus() {
        return status;
    }

    public void setStatus(LoanResultStatus status) {
        this.status = status;
    }

    public LoanUserType getLoanType() {
        return loanUserType;
    }

    public void setLoanType(LoanUserType loanUserType) {
        this.loanUserType = loanUserType;
    }

}
