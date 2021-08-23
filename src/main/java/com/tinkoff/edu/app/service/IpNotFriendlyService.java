package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.service.LoanCalcService;

/**
 * Service for not IP
 */
public class IpNotFriendlyService extends LoanCalcService {
    public IpNotFriendlyService(LoanCalcRepository loanCalcRepository) {
        super(loanCalcRepository);
    }
    
}
