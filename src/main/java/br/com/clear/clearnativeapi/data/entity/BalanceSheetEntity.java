package br.com.clear.clearnativeapi.data.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public record BalanceSheetEntity(
        @Id
        @GeneratedValue
        Long id,
        Integer month,
        Integer year,
        @OneToOne(fetch = FetchType.EAGER)
        CompanyEntity company,
        String status,
        @OneToOne(fetch = FetchType.EAGER)
        AccountEntity account,
        @ManyToMany
        Set<CompositionEntity> compositions
) {
}
