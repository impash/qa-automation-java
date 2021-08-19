package com.tinkoff.edu.app.response;

import com.tinkoff.edu.app.enums.LoanResultType;

public class LoanResponse {
    private final LoanResultType type;

   public LoanResponse (LoanResultType type){
        this.type = type;
    }

}
