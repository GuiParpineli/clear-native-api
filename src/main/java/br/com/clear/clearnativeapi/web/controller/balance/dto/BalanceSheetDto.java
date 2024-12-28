package br.com.clear.clearnativeapi.web.controller.balance.dto;

import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.web.controller.dto.AccountDto;
import br.com.clear.clearnativeapi.web.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.web.controller.dto.CompositionDto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link BalanceSheetEntity}
 */
public record BalanceSheetDto(Long id, int month, Integer year, CompanyDto company, String status,
                              AccountDto account, Set<CompositionDto> compositions) implements Serializable {
}
