package br.com.clear.clearnativeapi.domain.usecase.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.enums.Role;
import br.com.clear.clearnativeapi.domain.repository.balance.BalanceSheetRepository;

import java.util.List;

public class BalanceUseCaseImpl implements BalanceUseCase {
    private final BalanceSheetRepository repository;

    public BalanceUseCaseImpl(BalanceSheetRepository repository) {
        this.repository = repository;
    }

    @Override
    public BalanceSheet createBalance(BalanceSheet balance) {
        balance.setStatus(BalanceStatus.OPEN);
        return repository.save(balance);
    }

    @Override
    public void updateBalance(BalanceSheet request) {
        repository.update(request);
    }

    @Override
    public void closeBalance(BalanceSheet request) {
        request.setStatus(BalanceStatus.CLOSED);
        repository.update(request);
    }

    @Override
    public void reopenCloseBalance(BalanceSheet request, Responsible responsible) {
        if (request.getStatus() == BalanceStatus.PENDENT_REOPEN && responsible.getRole().isAdminOrSuper()) {
            request.setStatus(BalanceStatus.PROGRESS);
            repository.update(request);
        }
    }

    @Override
    public void deleteBalance(BalanceSheet request, Responsible responsible) {
        if (responsible.getRole() == Role.ADMIN || (responsible.getRole().isAdminOrSuper())) {
            repository.delete(request);
        }
    }

    @Override
    public void addComposition(Composition composition) {
        BalanceSheet balance = getBalanceById(composition.getBalance().getId());
        balance.getCompositions().add(composition);
        balance.setStatus(BalanceStatus.PROGRESS);
        repository.update(balance);
    }

    @Override
    public BalanceSheet getBalanceById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<BalanceSheet> getBalances(Company company) {
        return repository.findAll(company);
    }

    @Override
    public BalanceSheet getBalanceByResponsible(Responsible responsible) {
        return repository.getBalanceByResponsible(responsible);
    }

    @Override
    public List<BalanceSheet> getBalanceByStatus(String status) {
        return repository.getByStatus(status);
    }

    @Override
    public List<BalanceSheet> getBalanceByMonth(Company company, String month) {
        return repository.getByMonth(company, month);
    }

    @Override
    public BalanceSheet getBalanceByComposition(Company company, Composition composition) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByCompanyDtoAndResponsibleDto(Company request, Responsible responsible) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByCompanyDtoAndStatus(Company company, BalanceStatus balanceStatus) {
        return null;
    }

    @Override
    public List<BalanceSheet> getBalanceByCompanyDtoAndMonthAndYear(Long companyId, Integer month, Integer year) {
        return List.of();
    }

    @Override
    public List<BalanceSheet> getBalanceByCompanyDtoAndYear(Company company, Integer year) {
        return List.of();
    }

    @Override
    public BalanceSheet getBalanceByResponsibleDtoAndStatus(Responsible responsible, BalanceStatus balanceStatus) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByResponsibleDtoAndMonth(Responsible responsible, String month) {
        return null;
    }

    @Override
    public BalanceSheet getBalanceByResponsibleDtoAndYear(Responsible responsible, Integer year) {
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
