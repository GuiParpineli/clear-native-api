package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.BalanceSheetDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "balance_sheet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BalanceSheetEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Integer month;
    private Integer year;
    @OneToOne(fetch = FetchType.EAGER)
    private CompanyEntity company;
    private String status;
    @OneToOne(fetch = FetchType.EAGER)
    private AccountEntity account;
    @OneToMany(mappedBy = "balanceSheet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CompositionEntity> compositions = new LinkedHashSet<>();
}
