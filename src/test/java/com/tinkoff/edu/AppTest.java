package com.tinkoff.edu;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.enums.LoanUserType;
import com.tinkoff.edu.app.logger.LoanCalcLogger;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private LoanCalcController loanCalcController;
    private UUID[] uuids;
    private LoanResultStatus getStatus;

    @BeforeEach
    public void init() {
        uuids = new UUID[4];
        loanCalcController = new LoanCalcController();
        String fio = "Чувак Под Номером";
        LoanRequest loanRequest = new LoanRequest(LoanUserType.OOO, 10, 15000, fio + " 1");
        LoanResponse request = loanCalcController.createRequest(loanRequest);
        uuids[0] = request.getUuid();
        loanRequest = new LoanRequest(LoanUserType.OOO, 13, 15000, fio + " 2");
        request = loanCalcController.createRequest(loanRequest);
        uuids[1] = request.getUuid();
        loanRequest = new LoanRequest(LoanUserType.OOO, 9, 11000, fio + " 3");
        request = loanCalcController.createRequest(loanRequest);
        uuids[2] = request.getUuid();
        loanRequest = new LoanRequest(LoanUserType.IP, 10, 9000, fio + " 4");
        request = loanCalcController.createRequest(loanRequest);
        uuids[3] = request.getUuid();
    }

    //TODO
    // сделать параметризированные тесты с покрытием оставшихся кейсов OOO, IP, PERSON

    @Test
    @DisplayName("OOO, status == APPROVED")
    public void getPositiveStatusOOOByUUID() {
        getStatus = loanCalcController.getStatus(uuids[0]);
        LoanCalcLogger.info("Status: " + getStatus);
        assertEquals(LoanResultStatus.APPROVED, getStatus);
    }

    @Test
    @DisplayName("OOO, status == DECLINED")
    public void getNegativeStatusOOOByUUID(){
        getStatus = loanCalcController.getStatus(uuids[1]);
        LoanCalcLogger.info("Status: " + getStatus);
        assertEquals(LoanResultStatus.DECLINED, getStatus);
    }

    @Test
    @DisplayName("Ищем заявку по несуществующему uuid")
    public void getLoanRequestStatusByNonExistentUUID() {
        UUID nonExistentUuid = UUID.randomUUID();
        String err = "";
        try {
            getStatus = loanCalcController.getStatus(nonExistentUuid);
        }
        catch (Exception e){
            LoanCalcLogger.error(e.getMessage());
            err = e.getMessage();
        }
        assertTrue(err.contains("не найдено"));
    }

    @Test
    @DisplayName("Меняем присвоенный при создании статус на CHANGED")
    public void changeLoanRequestStatusByUUID() {
        loanCalcController.changeStatus(uuids[1], LoanResultStatus.CHANGED);
        LoanResultStatus status = loanCalcController.getStatus(uuids[1]);
        assertEquals(LoanResultStatus.CHANGED, status);
        LoanCalcLogger.info("Статус изменен на " + status);
    }
}