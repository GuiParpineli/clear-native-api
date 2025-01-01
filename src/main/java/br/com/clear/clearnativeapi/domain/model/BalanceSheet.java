package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.domain.model.enums.BalanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceSheet {
    private long id;
    private int month;
    private int year;
    private BalanceStatus status;
    private Company company;
    private Account account;
    private Set<Composition> compositions;

    public BalanceSheet(int month, int year, Company company, BalanceStatus status, Account account, Set<Composition> compositions) {
        setMonth(month);
        setYear(year);
        this.company = company;
        this.status = status;
        this.account = account;
        this.compositions = compositions;
    }

    public void setMonth(int month) {
        if (month > 1 && month < 13) this.month = month;
        else this.month = LocalDate.now().getMonthValue();
    }

    public void setYear(int year) {
        this.year = Math.max(year, LocalDate.now().getYear());
    }
}
