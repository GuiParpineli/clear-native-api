package br.com.clear.clearnativeapi.infrastructure.repository.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.repository.balance.BalanceSheetRepository;
import org.springframework.stereotype.Service;

@Service
public class BalanceSheetRepositoryImpl implements BalanceSheetRepository {
    private final BalanceSheetJpaRepository repository;

    public BalanceSheetRepositoryImpl(BalanceSheetJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void update(BalanceSheet request) {

    }

    @Override
    public BalanceSheet save(BalanceSheet balanceSheet) {
        return null;
    }

    @Override
    public BalanceSheet findById(Long id) {
        return null;
    }
}
