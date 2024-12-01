package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public record CompositionEntity(
        @Id
        @GeneratedValue
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
        @OneToOne
        ResponsibleEntity responsible,
        @ManyToOne
        BalanceSheetEntity balance
) {
}
