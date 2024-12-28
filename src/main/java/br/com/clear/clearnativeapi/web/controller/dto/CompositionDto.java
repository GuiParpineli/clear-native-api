package br.com.clear.clearnativeapi.web.controller.dto;

import br.com.clear.clearnativeapi.infrastructure.entity.CompositionEntity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link CompositionEntity}
 */
public record CompositionDto(
        Long id,
        Long taxNoteNumber,
        LocalDate emissionDate,
        LocalDate dueDate,
        Double iss,
        Double inss,
        Double irrf,
        Double csrf,
        Double credit,
        Double debit,
        String history,
        ResponsibleDto responsible
) implements Serializable {
}
