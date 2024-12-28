package br.com.clear.clearnativeapi.adapter.service.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.repository.balance.BalanceSheetRepository;
import br.com.clear.clearnativeapi.domain.usecase.balance.BalanceUseCase;
import br.com.clear.clearnativeapi.domain.usecase.balance.BalanceUseCaseImpl;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceUseCaseAdapter {
    private final BalanceUseCase balanceUseCase;

    public BalanceUseCaseAdapter(BalanceSheetRepository repository) {
        this.balanceUseCase = new BalanceUseCaseImpl(repository);
    }

    public List<BalanceSheet> getBalanceByCompanyDtoAndMonthAndYear(Long companyId, Integer month, Integer year) {
        return null;
    }

    public Long createBalance(BalanceSheetRequestDto dto) {
        return null;
    }

    public BalanceSheet getBalanceById(Long id) {
        return null;
    }
}
