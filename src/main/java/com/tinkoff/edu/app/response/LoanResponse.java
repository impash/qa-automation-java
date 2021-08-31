package com.tinkoff.edu.app.response;

import com.tinkoff.edu.app.enums.LoanResultType;

public class LoanResponse {
    final LoanResultType type;
    final int requestId;
    final String uuid;

    public LoanResponse(LoanResultType type, int requestId, String uuid){
        this.type = type;
        this.requestId = requestId;
        this.uuid = uuid;
    }

    public LoanResultType getType() {
        return type;
    }

    public int getRequestId() {
        return requestId;
    }

    @Override
    public String toString() {
        return "LoanResponse{" +
                "type=" + type +
                ", requestId=" + requestId +
                ", uuid=" + uuid +
                "}";
    }
}
