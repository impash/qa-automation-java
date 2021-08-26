package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.request.LoanRequest;

/**
 * Просто пример абстрактного класса
 */
public abstract class ParamValidatingService {
    public  int createRequest(LoanRequest request){
        if (request == null) throw new IllegalArgumentException();
        return 0;
    }
}
