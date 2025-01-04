package br.com.clear.clearnativeapi.domain.repository.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Responsible;

import java.util.List;

public interface BalanceSheetRepository {
    void update(BalanceSheet request);

    BalanceSheet save(BalanceSheet balanceSheet);

    BalanceSheet findById(Long id);

    void delete(BalanceSheet request);

    List<BalanceSheet> findAll(Company company);

    BalanceSheet getBalanceByResponsible(Responsible responsible);

    List<BalanceSheet> getByStatus(String status);

    List<BalanceSheet> getByMonth(Company company, String month);
}
