package br.com.clear.clearnativeapi.controller.balance.dto;

import br.com.clear.clearnativeapi.controller.dto.CompositionDto;

import java.util.List;

public record BalanceSheetRequestDto(
        Integer month,
        Integer year,
        Long companyId,
        Long accountId,
        List<CompositionDto> compositions
) {
}
