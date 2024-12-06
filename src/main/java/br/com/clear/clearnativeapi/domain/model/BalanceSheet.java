package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.domain.enums.BalanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class BalanceSheet {
    private long id;
    private int month;
    private int year;
    private Company company;
    private BalanceStatus status;
    private Account account;
    private Set<Composition> compositions;
}
