package com.tinkoff.edu;

import com.tinkoff.edu.app.controller.LoanCalcController;
import com.tinkoff.edu.app.dao.LoanRepositoryImpl;
import com.tinkoff.edu.app.dao.LoanRequestRecord;
import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.enums.LoanUserType;
import com.tinkoff.edu.app.request.LoanRequest;
import com.tinkoff.edu.app.response.LoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    LoanRequest loanRequest;
    LoanCalcController loanCalcController;
    LoanResponse request;

    @BeforeEach
    public void init() {
        loanCalcController = new LoanCalcController();
    }

    @Test
    public void getLoanRequestStatusByUUID() {
        String fio = "Чувак Под Номером ";
        loanRequest = new LoanRequest(LoanUserType.OOO, 10, 15000, fio+1);
        //выполняем запрос на создание заявки
        request = loanCalcController.createRequest(loanRequest);
        UUID id1 = request.getUuid();
        loanRequest = new LoanRequest(LoanUserType.OOO, 13, 15000, fio+2);
        request = loanCalcController.createRequest(loanRequest);
        UUID id2 = request.getUuid();
        loanRequest = new LoanRequest(LoanUserType.OOO, 9, 11000, fio+3);
        request = loanCalcController.createRequest(loanRequest);
        UUID id3 = request.getUuid();
        loanRequest = new LoanRequest(LoanUserType.OOO, 10, 9000, fio+4);
        request = loanCalcController.createRequest(loanRequest);
        UUID id4 = request.getUuid();
        //юзер выполняет запрос статуса getStatus по своему айди
        LoanRequestRecord getStatus = loanCalcController.getStatus(id1);
        System.out.println(
                        "ФИО: " + getStatus.getFio() +
                        "\nОрганизационно-правовая форма: " + getStatus.getLoanType() +
                        "\nUUID: " + getStatus.getUuid() +
                        "\nЗапрошенная сумма: " + getStatus.getAmount() +
                        "\nСрок: " + getStatus.getMonths() +
                        "\nStatus: " + getStatus.getStatus()
        );
        getStatus = loanCalcController.getStatus(id4);
        System.out.println(
                "ФИО: " + getStatus.getFio() +
                        "\nОрганизационно-правовая форма: " + getStatus.getLoanType() +
                        "\nUUID: " + getStatus.getUuid() +
                        "\nЗапрошенная сумма: " + getStatus.getAmount() +
                        "\nСрок: " + getStatus.getMonths() +
                        "\nStatus: " + getStatus.getStatus()
        );
    }

    @Test
    public void getLoanRequestStatusByNonExistentUUID() {
        String fio = "Чувак Под Номером ";
        UUID nExUuid= UUID.randomUUID();
        loanRequest = new LoanRequest(LoanUserType.OOO, 10, 15000, fio+1);
        request = loanCalcController.createRequest(loanRequest);

        //выполняем запрос статуса getStatus
        LoanRequestRecord getStatus = loanCalcController.getStatus(nExUuid);
        System.out.println(
                "ФИО: " + getStatus.getFio() +
                        "\nОрганизационно-правовая форма: " + getStatus.getLoanType() +
                        "\nUUID: " + getStatus.getUuid() +
                        "\nЗапрошенная сумма: " + getStatus.getAmount() +
                        "\nСрок: " + getStatus.getMonths() +
                        "\nStatus: " + getStatus.getStatus()
        );
    }

    @Test
    public void changeLoanRequestStatusByUUID() {
        String fio = "Чувак Под Номером ";
        loanRequest = new LoanRequest(LoanUserType.OOO, 10, 15000, fio+1);
        request = loanCalcController.createRequest(loanRequest);

        //выполняем запрос на изменение статуса changeStatus
        loanCalcController.changeStatus(request.getUuid(), LoanResultStatus.CHANGED);
        LoanRequestRecord record = loanCalcController.getStatus(request.getUuid());
        System.out.println("Статус заявки изменен на " + record.getStatus());
    }
}