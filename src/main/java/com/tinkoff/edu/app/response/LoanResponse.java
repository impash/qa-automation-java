package com.tinkoff.edu.app.response;

import com.tinkoff.edu.app.enums.LoanResultStatus;

import java.util.UUID;

public class LoanResponse {
    final LoanResultStatus status;

    final UUID uuid;

    public LoanResponse(LoanResultStatus status, UUID uuid){
        this.status = status;
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LoanResultStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "LoanResponse{" +
                "type=" + status +
                ", uuid=" + uuid +
                "}";
    }
}
