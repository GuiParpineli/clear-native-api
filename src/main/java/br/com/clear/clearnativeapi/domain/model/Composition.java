package br.com.clear.clearnativeapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Composition {
    private Long id;
    private Long taxNoteNumber;
    private LocalDate emissionDate;
    private LocalDate dueDate;
    private Double iss;
    private Double inss;
    private Double irrf;
    private Double csrf;
    private Double credit;
    private Double debit;
    private String history;
    private Responsible responsible;
    private BalanceSheet balance;
}
