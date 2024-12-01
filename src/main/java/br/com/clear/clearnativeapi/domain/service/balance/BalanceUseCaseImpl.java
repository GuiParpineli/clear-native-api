package br.com.clear.clearnativeapi.domain.service.balance;

import br.com.clear.clearnativeapi.controller.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.data.repository.BalanceSheetEntityRepository;
import br.com.clear.clearnativeapi.domain.enums.BalanceStatus;
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
    public Optional<BalanceSheetDto> createBalance(BalanceSheetDto request) {
        return Optional.empty();
    }

    @Override
    public void updateBalance(BalanceSheetDto request) {

    }

    @Override
    public void closeBalance(BalanceSheetDto request) {

    }

    @Override
    public void reopenCloseBalance(BalanceSheetDto request, ResponsibleDto ResponsibleDto) {

    }

    @Override
    public void deleteBalance(BalanceSheetDto request, ResponsibleDto ResponsibleDto) {

    }

    @Override
    public void addComposition(Long balanceId, CompositionDto composition, BalanceStatus status) {

    }

    @Override
    public Optional<BalanceSheetDto> getBalanceById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<BalanceSheetDto> getBalances(CompanyDto request) {
        return List.of();
    }

    @Override
    public Optional<BalanceSheetDto> getBalanceByResponsibleDto(ResponsibleDto request) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheetDto> getBalanceByAccountType(String type) {
        return Optional.empty();
    }

    @Override
    public List<BalanceSheetDto> getBalanceByStatus(String status) {
        return List.of();
    }

    @Override
    public List<BalanceSheetDto> getBalanceByMonth(CompanyDto CompanyDto, String month) {
        return List.of();
    }

    @Override
    public Optional<BalanceSheetDto> getBalanceByComposition(CompanyDto CompanyDto, CompositionDto composition) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheetDto> getBalanceByCompanyDtoAndResponsibleDto(CompanyDto request, ResponsibleDto ResponsibleDto) {
        return Optional.empty();
    }

    @Override
    public BalanceSheetDto getBalanceByCompanyDtoAndStatus(CompanyDto CompanyDto, BalanceStatus balanceStatus) {
        return null;
    }

    @Override
    public List<BalanceSheetDto> getBalanceByCompanyDtoAndMonth(CompanyDto CompanyDto, String month) {
        return List.of();
    }

    @Override
    public List<BalanceSheetDto> getBalanceByCompanyDtoAndYear(CompanyDto CompanyDto, Integer year) {
        return List.of();
    }

    @Override
    public Optional<BalanceSheetDto> getBalanceByResponsibleDtoAndStatus(ResponsibleDto ResponsibleDto, BalanceStatus balanceStatus) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheetDto> getBalanceByResponsibleDtoAndMonth(ResponsibleDto ResponsibleDto, String month) {
        return Optional.empty();
    }

    @Override
    public Optional<BalanceSheetDto> getBalanceByResponsibleDtoAndYear(ResponsibleDto ResponsibleDto, Integer year) {
        return Optional.empty();
    }

    @Override
    public List<BalanceSheetDto> getBalanceByYear(Company Company, Integer year) {
        return List.of();
    }

    @Override
    public void deleteComposition(Composition composition) {

    }
}
