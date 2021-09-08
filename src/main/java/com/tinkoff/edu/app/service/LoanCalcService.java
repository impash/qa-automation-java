package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.dao.LoanCalcRepository;
import com.tinkoff.edu.app.dao.LoanRequestRecord;
import com.tinkoff.edu.app.enums.LoanResultStatus;
import com.tinkoff.edu.app.enums.LoanUserType;
import com.tinkoff.edu.app.request.LoanRequest;

import java.util.UUID;

public class LoanCalcService implements LoanServiceInterface {
    LoanCalcRepository repo;
    LoanRequestRecord record;

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * CreateNewLoanRequest
     *
     * @param request
     * @return Выполняем новый запрос на кредит
     */
    @Override
    public UUID createRequest(LoanRequest request) {

        if ((request.getFio().length() < 10) || (request.getFio().length() > 100)) {
            throw new IllegalArgumentException("ФИО должно содержать не менее 10 и не более 100 символов!");
        }

        if (request.getType() == LoanUserType.PERSON) {
            if (request.getAmount() <= 10_000 & request.getMonths() <= 12) {
                repo.save(request, LoanResultStatus.APPROVED);
            }
            repo.save(request, LoanResultStatus.DECLINED);
        }
        else if (request.getType() == LoanUserType.OOO) {
            if (request.getAmount() <= 10_000) {
                repo.save(request, LoanResultStatus.DECLINED);
            } else if (request.getAmount() > 10_000 & request.getMonths() < 12) {
                repo.save(request, LoanResultStatus.APPROVED);
            } else if (request.getAmount() > 10_000 & request.getMonths() >= 12) {
                repo.save(request, LoanResultStatus.DECLINED);
            }
        }
        else if (request.getType() == LoanUserType.IP) {
            repo.save(request, LoanResultStatus.DECLINED);
        }


//        if (request.getType().equals(LoanUserType.PERSON)
//                & request.getAmount() <= 10_000 & request.getMonths() <= 12) {
//            repo.save(request, LoanResultStatus.APPROVED);
//        } else if (request.getType().equals(LoanUserType.PERSON) & request.getAmount() > 10_000 & request.getMonths() > 12) {
//            repo.save(request, LoanResultStatus.DECLINED);
//        } else if (request.getType().equals(LoanUserType.OOO) & request.getAmount() <= 10_000) {
//            repo.save(request, LoanResultStatus.DECLINED);
//        } else if (request.getType().equals(LoanUserType.OOO) & request.getAmount() > 10_000 & request.getMonths() < 12) {
//            repo.save(request, LoanResultStatus.APPROVED);
//        } else if (request.getType().equals(LoanUserType.OOO) & request.getAmount() > 10_000 & request.getMonths() >= 12) {
//            repo.save(request, LoanResultStatus.DECLINED);
//        } else if (request.getType().equals(LoanUserType.IP)) {
//            repo.save(request, LoanResultStatus.DECLINED);
//        }
        throw new IllegalArgumentException("-1");
    }

    /**
     * GetStatusByUser
     *
     * @param uuid
     * @return Юзер запрашивает статус по своему uuid
     */
    public LoanRequestRecord getStatus(UUID uuid) {
        try {
            System.out.println("\n_ВЫПОЛНЕН ЗАПРОС по UUID: " + uuid + "\n");
            return repo.getRecordByUuid(uuid);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Кажется, что-то пошло не по плану ... " + e);
        }
        return null;
    }

    /**
     * ChangeStatus
     *
     * @param uuid
     * @param status
     */
    public void changeStatus(UUID uuid, LoanResultStatus status) {
        repo.changeStatus(uuid, status);
    }
}
