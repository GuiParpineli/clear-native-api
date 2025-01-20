package br.com.clear.clearnativeapi.domain.usecase.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import org.springframework.expression.AccessException;

import java.util.List;

public interface BalanceUseCase {
    BalanceSheet createBalance(BalanceSheet request);

    void updateBalance(BalanceSheet request);

    void closeBalance(Long companyID, Long balanceId) throws AccessException;

    void reopenCloseBalance(Long companyID, Long balanceId, Long responsibleID);

    void deleteBalance(BalanceSheet request, Responsible responsible);

    void addComposition(Composition composition);

    BalanceSheet getBalanceById(Long companyId, Long id);

    List<BalanceSheet> getBalances(Company request);

    List<BalanceSheet> getBalanceByStatus(Company company, String status);

    List<BalanceSheet> getBalanceByMonth(Company company, String month);

    BalanceSheet getBalanceByCompanyDtoAndResponsibleDto(Company request, Responsible responsible);

    BalanceSheet getBalanceByCompanyDtoAndStatus(Company company, BalanceStatus balanceStatus);

    List<BalanceSheet> getBalanceByMonthAndYear(Long companyId, Integer month, Integer year);

    List<BalanceSheet> getBalanceByCompanyDtoAndYear(Company company, Integer year);

    BalanceSheet getBalanceByResponsibleDtoAndStatus(Responsible responsible, BalanceStatus balanceStatus);

    BalanceSheet getBalanceByResponsibleDtoAndMonth(Responsible responsible, String month);

    BalanceSheet getBalanceByResponsibleDtoAndYear(Responsible responsible, Integer year);

    List<BalanceSheet> getBalanceByYear(Company company, Integer year);
}
