package br.com.clear.clearnativeapi.domain.repository.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;

public interface BalanceSheetRepository {
    void update(BalanceSheet request);

    BalanceSheet save(BalanceSheet balanceSheet);

    BalanceSheet findById(Long id);
}
