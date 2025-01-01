package br.com.clear.clearnativeapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "balance_sheet")
@NoArgsConstructor
@Getter
@Setter
public class BalanceSheetEntity {
    @Id
    @GeneratedValue
    private Long id;
    private int month;
    private int year;
    private String status;
    @OneToOne(fetch = FetchType.EAGER)
    private CompanyEntity company;
    @OneToOne(fetch = FetchType.EAGER)
    private AccountEntity account;
    @OneToMany(mappedBy = "balanceSheet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CompositionEntity> compositions = new LinkedHashSet<>();

    public BalanceSheetEntity(Long id) {
        this.id = id;
    }
}
