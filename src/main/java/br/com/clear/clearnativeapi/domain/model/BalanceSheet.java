package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceSheet {
    private long id;
    private int month;
    private int year;
    private Company company;
    private BalanceStatus status;
    private Account account;
    private Set<Composition> compositions;

    public BalanceSheet(int month, int year, Company company, BalanceStatus status, Account account, Set<Composition> compositions) {
        this.month = month;
        this.year = year;
        this.company = company;
        this.status = status;
        this.account = account;
        this.compositions = compositions;
    }
}
