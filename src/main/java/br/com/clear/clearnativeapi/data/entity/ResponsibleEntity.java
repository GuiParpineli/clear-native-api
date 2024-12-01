package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public record ResponsibleEntity(
        @Id
        @GeneratedValue
        Long id,
        String name,
        String email,
        String phone,
        @OneToOne
        CompanyEntity company,
        String role
) {
    public ResponsibleDto toDto() {
        return new ResponsibleDto(id, name, email, company.toDto());
    }
}
