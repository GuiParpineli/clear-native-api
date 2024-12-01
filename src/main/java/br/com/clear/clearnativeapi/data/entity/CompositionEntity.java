package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.adapter.mapper.responsible.RessponsibleMapper;
import br.com.clear.clearnativeapi.controller.dto.CompositionDto;
import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "composition")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompositionEntity {
    @Id
    @GeneratedValue
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
    @OneToOne
    private ResponsibleEntity responsible;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "balance_sheet_id")
    private BalanceSheetEntity balanceSheet;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CompositionEntity that = (CompositionEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
