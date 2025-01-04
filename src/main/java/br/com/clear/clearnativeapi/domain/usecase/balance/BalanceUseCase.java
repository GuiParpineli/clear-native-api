package br.com.clear.clearnativeapi.domain.usecase.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;

import java.util.List;

public interface BalanceUseCase {
    BalanceSheet createBalance(BalanceSheet request);

    void updateBalance(BalanceSheet request);

    void closeBalance(BalanceSheet request);

    void reopenCloseBalance(BalanceSheet request, Responsible responsible);

    void deleteBalance(BalanceSheet request, Responsible responsible);

    void addComposition(Composition composition);

    BalanceSheet getBalanceById(Long id);

    List<BalanceSheet> getBalances(Company request);

    BalanceSheet getBalanceByResponsible(Responsible request);

    List<BalanceSheet> getBalanceByStatus(String status);

    List<BalanceSheet> getBalanceByMonth(Company company, String month);

    BalanceSheet getBalanceByComposition(Company company, Composition composition);

    BalanceSheet getBalanceByCompanyDtoAndResponsibleDto(Company request, Responsible responsible);

    BalanceSheet getBalanceByCompanyDtoAndStatus(Company company, BalanceStatus balanceStatus);

    List<BalanceSheet> getBalanceByCompanyDtoAndMonthAndYear(Long companyId, Integer month, Integer year);

    List<BalanceSheet> getBalanceByCompanyDtoAndYear(Company company, Integer year);

    BalanceSheet getBalanceByResponsibleDtoAndStatus(Responsible responsible, BalanceStatus balanceStatus);

    BalanceSheet getBalanceByResponsibleDtoAndMonth(Responsible responsible, String month);

    BalanceSheet getBalanceByResponsibleDtoAndYear(Responsible responsible, Integer year);

    List<BalanceSheet> getBalanceByYear(Company company, Integer year);

    void deleteComposition(Composition composition);
}
