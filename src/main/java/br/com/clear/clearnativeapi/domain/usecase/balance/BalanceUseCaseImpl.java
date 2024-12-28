package br.com.clear.clearnativeapi.domain.usecase.balance;

import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;
import br.com.clear.clearnativeapi.domain.repository.balance.BalanceSheetRepository;
import br.com.clear.clearnativeapi.web.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.web.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.web.controller.dto.ResponsibleDto;

import java.util.List;

class BalanceUseCaseImpl implements BalanceUseCase {
    private final BalanceSheetRepository repository;

    BalanceUseCaseImpl(BalanceSheetRepository repository) {
        this.repository = repository;
    }

    @Override
    public BalanceSheet createBalance(BalanceSheet balance) {
        return repository.save(balance);
    }

    @Override
    public void updateBalance(BalanceSheet request) {
        repository.update(request);
    }

    @Override
    public void closeBalance(BalanceSheet request) {

    }

    @Override
    public void reopenCloseBalance(BalanceSheet request, ResponsibleDto ResponsibleDto) {

    }

    @Override
    public void deleteBalance(BalanceSheet request, ResponsibleDto ResponsibleDto) {

    }

    @Override
    public void addComposition(Long balanceId, CompositionDto composition, BalanceStatus status) {

    }

    @Override
    public BalanceSheet getBalanceById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<BalanceSheet> getBalances(CompanyDto request) {
        return List.of();
    }

    @Override
    public BalanceSheet getBalanceByResponsibleDto(ResponsibleDto request) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByAccountType(String type) {
        return null;
    }

    @Override
    public List<BalanceSheet> getBalanceByStatus(String status) {
        return List.of();
    }

    @Override
    public List<BalanceSheet> getBalanceByMonth(CompanyDto CompanyDto, String month) {
        return List.of();
    }

    @Override
    public BalanceSheet getBalanceByComposition(CompanyDto CompanyDto, CompositionDto composition) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByCompanyDtoAndResponsibleDto(CompanyDto request, ResponsibleDto ResponsibleDto) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByCompanyDtoAndStatus(CompanyDto CompanyDto, BalanceStatus balanceStatus) {
        return null;
    }

    @Override
    public List<BalanceSheet> getBalanceByCompanyDtoAndMonthAndYear(Long companyId, Integer month, Integer year) {
        return List.of();
    }

    @Override
    public List<BalanceSheet> getBalanceByCompanyDtoAndYear(CompanyDto CompanyDto, Integer year) {
        return List.of();
    }

    @Override
    public BalanceSheet getBalanceByResponsibleDtoAndStatus(ResponsibleDto ResponsibleDto, BalanceStatus balanceStatus) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByResponsibleDtoAndMonth(ResponsibleDto ResponsibleDto, String month) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByResponsibleDtoAndYear(ResponsibleDto ResponsibleDto, Integer year) {
        return null;
    }

    @Override
    public List<BalanceSheet> getBalanceByYear(Company Company, Integer year) {
        return List.of();
    }

    @Override
    public void deleteComposition(Composition composition) {

    }
}
