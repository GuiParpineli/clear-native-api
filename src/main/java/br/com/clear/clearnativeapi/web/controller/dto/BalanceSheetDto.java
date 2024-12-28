package br.com.clear.clearnativeapi.web.controller.dto;

import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link BalanceSheetEntity}
 */
public record BalanceSheetDto(Long id, int month, Integer year, CompanyDto company, String status,
                              AccountDto account, Set<CompositionDto> compositions) implements Serializable {
}
