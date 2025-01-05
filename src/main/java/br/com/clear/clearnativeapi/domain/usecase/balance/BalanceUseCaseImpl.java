package br.com.clear.clearnativeapi.domain.usecase.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Composition;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import br.com.clear.clearnativeapi.domain.model.enums.Role;
import br.com.clear.clearnativeapi.domain.repository.BalanceSheetRepository;
import br.com.clear.clearnativeapi.domain.repository.ResponsibleRepository;
import org.springframework.expression.AccessException;

import java.util.List;

public class BalanceUseCaseImpl implements BalanceUseCase {
    private final BalanceSheetRepository repository;
    private final ResponsibleRepository responsibleRepository;

    public BalanceUseCaseImpl(BalanceSheetRepository repository, ResponsibleRepository responsibleRepository) {
        this.repository = repository;
        this.responsibleRepository = responsibleRepository;
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
    public void closeBalance(Long companyID, Long balanceId) throws AccessException {
        BalanceSheet balance = repository.findById(balanceId);
        if (balance.getCompany().getId() != companyID)
            throw new AccessException("Failed,company does not belong to balance sheet");
        balance.setStatus(BalanceStatus.CLOSED);
        repository.update(balance);
    }

    @Override
    public void reopenCloseBalance(Long companyID, Long balanceId, Long responsibleId) {
        BalanceSheet request = repository.findById(balanceId);
        Responsible responsible = responsibleRepository.findById(responsibleId);
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
        BalanceSheet balance = repository.findById(composition.getBalance().getId());
        balance.getCompositions().add(composition);
        balance.setStatus(BalanceStatus.PROGRESS);
        repository.update(balance);
    }

    @Override
    public BalanceSheet getBalanceById(Long companyID, Long id) {
        return repository.findByCompanyAndId(companyID, id);
    }

    @Override
    public List<BalanceSheet> getBalances(Company company) {
        return repository.findAll(company);
    }

    @Override
    public List<BalanceSheet> getBalanceByStatus(Company company, String status) {
        return repository.getByStatus(company, status);
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
    public List<BalanceSheet> getBalanceByMonthAndYear(Long companyId, Integer month, Integer year) {
        return repository.findByMonthAndYear(companyId, month, year);
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
