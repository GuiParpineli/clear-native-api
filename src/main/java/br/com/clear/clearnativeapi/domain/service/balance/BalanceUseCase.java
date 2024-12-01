package br.com.clear.clearnativeapi.domain.service.balance;

import br.com.clear.clearnativeapi.controller.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.domain.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;

import java.util.List;
import java.util.Optional;

public interface BalanceUseCase {
    Optional<BalanceSheetDto> createBalance(BalanceSheetDto request);

    void updateBalance(BalanceSheetDto request);

    void closeBalance(BalanceSheetDto request);

    void reopenCloseBalance(BalanceSheetDto request, ResponsibleDto ResponsibleDto);

    void deleteBalance(BalanceSheetDto request, ResponsibleDto ResponsibleDto);

    void addComposition(Long balanceId, CompositionDto composition, BalanceStatus status);

    Optional<BalanceSheetDto> getBalanceById(Long id);

    List<BalanceSheetDto> getBalances(CompanyDto request);

    Optional<BalanceSheetDto> getBalanceByResponsibleDto(ResponsibleDto request);

    Optional<BalanceSheetDto> getBalanceByAccountType(String type);

    List<BalanceSheetDto> getBalanceByStatus(String status);

    List<BalanceSheetDto> getBalanceByMonth(CompanyDto CompanyDto, String month);

    Optional<BalanceSheetDto> getBalanceByComposition(CompanyDto CompanyDto, CompositionDto composition);

    Optional<BalanceSheetDto> getBalanceByCompanyDtoAndResponsibleDto(CompanyDto request, ResponsibleDto ResponsibleDto);

    BalanceSheetDto getBalanceByCompanyDtoAndStatus(CompanyDto CompanyDto, BalanceStatus balanceStatus);

    List<BalanceSheetDto> getBalanceByCompanyDtoAndMonth(CompanyDto CompanyDto, String month);

    List<BalanceSheetDto> getBalanceByCompanyDtoAndYear(CompanyDto CompanyDto, Integer year);

    Optional<BalanceSheetDto> getBalanceByResponsibleDtoAndStatus(ResponsibleDto ResponsibleDto, BalanceStatus balanceStatus);

    Optional<BalanceSheetDto> getBalanceByResponsibleDtoAndMonth(ResponsibleDto ResponsibleDto, String month);

    Optional<BalanceSheetDto> getBalanceByResponsibleDtoAndYear(ResponsibleDto ResponsibleDto, Integer year);

    List<BalanceSheetDto> getBalanceByYear(Company Company, Integer year);

    void deleteComposition(Composition composition);
}
