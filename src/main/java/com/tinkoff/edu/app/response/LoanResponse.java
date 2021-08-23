package com.tinkoff.edu.app.response;

import com.tinkoff.edu.app.enums.LoanResultType;

public class LoanResponse {
    final LoanResultType type;
    final int requestId;

    public LoanResponse(LoanResultType type, int requestId){
        this.type = type;
        this.requestId = requestId;
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
                '}';
    }
}
