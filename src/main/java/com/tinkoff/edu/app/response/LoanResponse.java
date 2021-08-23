package com.tinkoff.edu.app.response;

import com.tinkoff.edu.app.enums.LoanResultType;

public class LoanResponse {
    final LoanResultType type;
    final int requestId;

    public LoanResponse(LoanResultType type, int requestId){
        this.type = type;
        this.requestId = requestId;
    }
}
