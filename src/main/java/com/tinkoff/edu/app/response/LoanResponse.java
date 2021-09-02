package com.tinkoff.edu.app.response;

import com.tinkoff.edu.app.enums.LoanResultType;

import java.util.UUID;

public class LoanResponse {
    final LoanResultType type;
//    final int requestId;
    final UUID uuid;

    public LoanResponse(LoanResultType status, UUID uuid){
        this.type = status;
        this.uuid = uuid;
    }

    public LoanResultType getType() {
        return type;
    }

//    public int getRequestId() {
//        return requestId;
//    }

    @Override
    public String toString() {
        return "LoanResponse{" +
                "type=" + type +
                ", uuid=" + uuid +
                "}";
    }
}
