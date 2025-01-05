package br.com.clear.clearnativeapi.adapter.service;

import br.com.clear.clearnativeapi.adapter.mapper.BalanceSheetMapper;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.repository.BalanceSheetRepository;
import br.com.clear.clearnativeapi.domain.repository.ResponsibleRepository;
import br.com.clear.clearnativeapi.domain.usecase.balance.BalanceUseCase;
import br.com.clear.clearnativeapi.domain.usecase.balance.BalanceUseCaseImpl;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetRequestDto;
import br.com.clear.clearnativeapi.web.shared.dto.DefaultSuccessDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BalanceUseCaseAdapter {
    private final BalanceUseCase balanceUseCase;

    public BalanceUseCaseAdapter(BalanceSheetRepository repository, ResponsibleRepository responsibleRepository) {
        this.balanceUseCase = new BalanceUseCaseImpl(repository, responsibleRepository);
    }

    public List<BalanceSheetDto> getBalanceByMonthAndYear(Long companyId, Integer month, Integer year) {
        return balanceUseCase.getBalanceByMonthAndYear(companyId, month, year)
                .stream()
                .map(BalanceSheetMapper::toDto)
                .toList();
    }

    public Long createBalance(Long companyId, BalanceSheetRequestDto dto) {
        BalanceSheet model = BalanceSheetMapper.toModel(companyId, dto);
        return balanceUseCase.createBalance(model).getId();
    }

    public BalanceSheetDto getBalanceById(Long id) {
        return BalanceSheetMapper.toDto(balanceUseCase.getBalanceById(id));
    }

    public DefaultSuccessDto updateBalance(Long companyId, BalanceSheetRequestDto dto) {
        BalanceSheet model = BalanceSheetMapper.toModel(companyId, dto);
        balanceUseCase.updateBalance(model);
        return new DefaultSuccessDto(HttpStatus.ACCEPTED.value(), "Balance updated");
    }

    public DefaultSuccessDto closeBalance(Long companyID, Long balanceId) {
        try {
            balanceUseCase.closeBalance(companyID, balanceId);
        } catch (AccessException e) {
            log.error(e.getMessage());
            return new DefaultSuccessDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
        return new DefaultSuccessDto(HttpStatus.ACCEPTED.value(), "Balance closed");
    }

    public DefaultSuccessDto reopenBalance(Long companyID, Long balanceId, Long responsibleId) {
        balanceUseCase.reopenCloseBalance(companyID, balanceId, responsibleId);
        return new DefaultSuccessDto(HttpStatus.ACCEPTED.value(), "Balance reopened");
    }
}
