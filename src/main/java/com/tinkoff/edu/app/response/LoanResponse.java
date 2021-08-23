package com.tinkoff.edu.app.response;

import com.tinkoff.edu.app.enums.LoanResultType;

public class LoanResponse {
    final LoanResultType type;
    private final int requestId;

   public LoanResponse(LoanResultType type, int requestId){
        this.type = type;
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }
}
