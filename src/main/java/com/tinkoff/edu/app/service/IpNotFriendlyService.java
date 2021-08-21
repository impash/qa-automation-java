package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.service.LoanCalcService;

public class IpNotFriendlyService extends LoanCalcService {
    public IpNotFriendlyService(LoanCalcRepository repo) {
        super(repo);
    }
    
}
