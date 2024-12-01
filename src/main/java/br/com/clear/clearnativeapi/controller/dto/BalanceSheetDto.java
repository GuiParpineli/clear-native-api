package br.com.clear.clearnativeapi.controller.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link br.com.clear.clearnativeapi.data.entity.BalanceSheetEntity}
 */
public record BalanceSheetDto(Long id, String month, Integer year, CompanyDto company, String status,
                              AccountDto account, Set<CompositionDto> compositions) implements Serializable {
}
