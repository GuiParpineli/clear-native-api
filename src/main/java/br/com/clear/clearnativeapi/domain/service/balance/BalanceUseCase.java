package br.com.clear.clearnativeapi.domain.service.balance;

import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.domain.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;

import java.util.List;
import java.util.Optional;

public interface BalanceUseCase {
    Long createBalance(BalanceSheet request);

    void updateBalance(BalanceSheet request);

    void closeBalance(BalanceSheet request);

    void reopenCloseBalance(BalanceSheet request, ResponsibleDto ResponsibleDto);

    void deleteBalance(BalanceSheet request, ResponsibleDto ResponsibleDto);

    void addComposition(Long balanceId, CompositionDto composition, BalanceStatus status);

    Optional<BalanceSheet> getBalanceById(Long id);

    List<BalanceSheet> getBalances(CompanyDto request);

    Optional<BalanceSheet> getBalanceByResponsibleDto(ResponsibleDto request);

    Optional<BalanceSheet> getBalanceByAccountType(String type);

    List<BalanceSheet> getBalanceByStatus(String status);

    List<BalanceSheet> getBalanceByMonth(CompanyDto CompanyDto, String month);

    Optional<BalanceSheet> getBalanceByComposition(CompanyDto CompanyDto, CompositionDto composition);

    Optional<BalanceSheet> getBalanceByCompanyDtoAndResponsibleDto(CompanyDto request, ResponsibleDto ResponsibleDto);

    BalanceSheet getBalanceByCompanyDtoAndStatus(CompanyDto CompanyDto, BalanceStatus balanceStatus);

    List<BalanceSheet> getBalanceByCompanyDtoAndMonthAndYear(Long companyId, Integer month, Integer year);

    List<BalanceSheet> getBalanceByCompanyDtoAndYear(CompanyDto CompanyDto, Integer year);

    Optional<BalanceSheet> getBalanceByResponsibleDtoAndStatus(ResponsibleDto ResponsibleDto, BalanceStatus balanceStatus);

    Optional<BalanceSheet> getBalanceByResponsibleDtoAndMonth(ResponsibleDto ResponsibleDto, String month);

    Optional<BalanceSheet> getBalanceByResponsibleDtoAndYear(ResponsibleDto ResponsibleDto, Integer year);

    List<BalanceSheet> getBalanceByYear(Company Company, Integer year);

    void deleteComposition(Composition composition);
}
