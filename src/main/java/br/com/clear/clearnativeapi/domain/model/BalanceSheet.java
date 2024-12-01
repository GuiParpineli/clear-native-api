package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.domain.enums.BalanceStatus;
import lombok.Data;

import java.util.Set;

@Data
public class BalanceSheet {
    private Long id;
    private int month;
    private Integer year;
    private Company company;
    private BalanceStatus status;
    private Account account;
    private Set<Composition> compositions;
}
