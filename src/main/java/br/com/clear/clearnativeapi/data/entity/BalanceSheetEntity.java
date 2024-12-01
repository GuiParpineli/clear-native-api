package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.BalanceSheetDto;
import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;

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
    public BalanceSheetDto toDto() {
        return new BalanceSheetDto(
                id,
                month.toString(),
                year,
                company.toDto(),
                status,
                account.toDto(),
                compositions.stream().map(CompositionEntity::toDto).collect(Collectors.toSet())
        );
    }
}
