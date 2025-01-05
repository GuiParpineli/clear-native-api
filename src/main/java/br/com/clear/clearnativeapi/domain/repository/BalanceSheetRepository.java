package br.com.clear.clearnativeapi.domain.repository;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Company;

import java.util.List;

public interface BalanceSheetRepository {
    void update(BalanceSheet request);

    BalanceSheet save(BalanceSheet balanceSheet);

    BalanceSheet findById(Long id);

    void delete(BalanceSheet request);

    List<BalanceSheet> findAll(Company company);

    List<BalanceSheet> getByStatus(Company company, String status);

    List<BalanceSheet> getByMonth(Company company, String month);

    List<BalanceSheet> findByMonthAndYear(Long companyId, Integer month, Integer year);

    BalanceSheet findByCompanyAndId(Long companyID, Long id);
}
