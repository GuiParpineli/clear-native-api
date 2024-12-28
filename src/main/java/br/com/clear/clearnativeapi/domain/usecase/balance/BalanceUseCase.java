package br.com.clear.clearnativeapi.domain.usecase.balance;

import br.com.clear.clearnativeapi.web.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.web.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.web.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;

import java.util.List;

public interface BalanceUseCase {
    BalanceSheet createBalance(BalanceSheet request);

    void updateBalance(BalanceSheet request);

    void closeBalance(BalanceSheet request);

    void reopenCloseBalance(BalanceSheet request, ResponsibleDto ResponsibleDto);

    void deleteBalance(BalanceSheet request, ResponsibleDto ResponsibleDto);

    void addComposition(Long balanceId, CompositionDto composition, BalanceStatus status);

    BalanceSheet getBalanceById(Long id);

    List<BalanceSheet> getBalances(CompanyDto request);

    BalanceSheet getBalanceByResponsibleDto(ResponsibleDto request);

    BalanceSheet getBalanceByAccountType(String type);

    List<BalanceSheet> getBalanceByStatus(String status);

    List<BalanceSheet> getBalanceByMonth(CompanyDto CompanyDto, String month);

    BalanceSheet getBalanceByComposition(CompanyDto CompanyDto, CompositionDto composition);

    BalanceSheet getBalanceByCompanyDtoAndResponsibleDto(CompanyDto request, ResponsibleDto ResponsibleDto);

    BalanceSheet getBalanceByCompanyDtoAndStatus(CompanyDto CompanyDto, BalanceStatus balanceStatus);

    List<BalanceSheet> getBalanceByCompanyDtoAndMonthAndYear(Long companyId, Integer month, Integer year);

    List<BalanceSheet> getBalanceByCompanyDtoAndYear(CompanyDto CompanyDto, Integer year);

    BalanceSheet getBalanceByResponsibleDtoAndStatus(ResponsibleDto ResponsibleDto, BalanceStatus balanceStatus);

    BalanceSheet getBalanceByResponsibleDtoAndMonth(ResponsibleDto ResponsibleDto, String month);

    BalanceSheet getBalanceByResponsibleDtoAndYear(ResponsibleDto ResponsibleDto, Integer year);

    List<BalanceSheet> getBalanceByYear(Company Company, Integer year);

    void deleteComposition(Composition composition);
}
