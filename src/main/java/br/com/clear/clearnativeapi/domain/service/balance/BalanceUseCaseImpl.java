package br.com.clear.clearnativeapi.domain.service.balance;

import br.com.clear.clearnativeapi.adapter.mapper.balance.BalanceSheetMapper;
import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.data.repository.BalanceSheetEntityRepository;
import br.com.clear.clearnativeapi.domain.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class BalanceUseCaseImpl implements BalanceUseCase {
    private final BalanceSheetEntityRepository repository;

    BalanceUseCaseImpl(BalanceSheetEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long createBalance(BalanceSheet request) {
        return repository.save(BalanceSheetMapper.toEntity(request)).getId();
    }

    @Override
    public void updateBalance(BalanceSheet request) {

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
    public Optional<BalanceSheet> getBalanceById(Long id) {
        return repository.findById(id).map(BalanceSheetMapper::toModel);
    }

    @Override
    public List<BalanceSheet> getBalances(CompanyDto request) {
        return List.of();
    }

    @Override
    public Optional<BalanceSheet> getBalanceByResponsibleDto(ResponsibleDto request) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheet> getBalanceByAccountType(String type) {
        return Optional.empty();
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
    public Optional<BalanceSheet> getBalanceByComposition(CompanyDto CompanyDto, CompositionDto composition) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheet> getBalanceByCompanyDtoAndResponsibleDto(CompanyDto request, ResponsibleDto ResponsibleDto) {
        return Optional.empty();
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
    public Optional<BalanceSheet> getBalanceByResponsibleDtoAndStatus(ResponsibleDto ResponsibleDto, BalanceStatus balanceStatus) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheet> getBalanceByResponsibleDtoAndMonth(ResponsibleDto ResponsibleDto, String month) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheet> getBalanceByResponsibleDtoAndYear(ResponsibleDto ResponsibleDto, Integer year) {
        return Optional.empty();
    }

    @Override
    public List<BalanceSheet> getBalanceByYear(Company Company, Integer year) {
        return List.of();
    }

    @Override
    public void deleteComposition(Composition composition) {

    }
}
