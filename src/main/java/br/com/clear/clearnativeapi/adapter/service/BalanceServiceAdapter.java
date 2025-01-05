package br.com.clear.clearnativeapi.adapter.service;

import br.com.clear.clearnativeapi.adapter.mapper.BalanceSheetMapper;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.repository.BalanceSheetRepository;
import br.com.clear.clearnativeapi.domain.repository.ResponsibleRepository;
import br.com.clear.clearnativeapi.domain.usecase.balance.BalanceUseCase;
import br.com.clear.clearnativeapi.domain.usecase.balance.BalanceUseCaseImpl;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetDto;
import br.com.clear.clearnativeapi.web.controller.balance.dto.BalanceSheetRequestDto;
import br.com.clear.clearnativeapi.web.shared.dto.DefaultResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BalanceServiceAdapter {
    private final BalanceUseCase balanceUseCase;

    public BalanceServiceAdapter(BalanceSheetRepository repository, ResponsibleRepository responsibleRepository) {
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

    public BalanceSheetDto getBalanceById(Long companyID, Long balancedId) {
        return BalanceSheetMapper.toDto(balanceUseCase.getBalanceById(companyID, balancedId));
    }

    public DefaultResponseDto updateBalance(Long companyId, BalanceSheetRequestDto dto) {
        BalanceSheet model = BalanceSheetMapper.toModel(companyId, dto);
        balanceUseCase.updateBalance(model);
        return new DefaultResponseDto(HttpStatus.ACCEPTED.value(), "Balance updated");
    }

    public DefaultResponseDto closeBalance(Long companyID, Long balanceId) {
        try {
            balanceUseCase.closeBalance(companyID, balanceId);
        } catch (AccessException e) {
            log.error(e.getMessage());
            return new DefaultResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
        return new DefaultResponseDto(HttpStatus.ACCEPTED.value(), "Balance closed");
    }

    public DefaultResponseDto reopenBalance(Long companyID, Long balanceId, Long responsibleId) {
        balanceUseCase.reopenCloseBalance(companyID, balanceId, responsibleId);
        return new DefaultResponseDto(HttpStatus.ACCEPTED.value(), "Balance reopened");
    }
}
