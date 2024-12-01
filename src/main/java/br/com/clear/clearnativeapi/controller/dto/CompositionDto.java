package br.com.clear.clearnativeapi.controller.dto;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Responsible;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link br.com.clear.clearnativeapi.data.entity.CompositionEntity}
 */
public record CompositionDto(Long id, Long taxNoteNumber, LocalDate emissionDate, LocalDate dueDate, Double iss,
                             Double inss, Double irrf, Double csrf, Double credit, Double debit, String history,
                             ResponsibleDto responsible, BalanceSheetDto balance) implements Serializable {
}
