package br.com.clear.clearnativeapi.web.controller.balance.dto;

import br.com.clear.clearnativeapi.web.controller.dto.CompositionDto;

import java.util.List;

public record BalanceSheetRequestDto(
        Integer month,
        Integer year,
        Long companyId,
        Long accountId,
        List<CompositionDto> compositions
) {
}
