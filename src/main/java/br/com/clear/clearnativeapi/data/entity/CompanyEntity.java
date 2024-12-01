package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public record CompanyEntity(
        @Id
        @GeneratedValue
        Long id,
        String name,
        String cnpj,
        String email,
        String phone,
        @OneToOne
        AddressEntity address
) {
    public CompanyDto toDto() {
        return new CompanyDto(id, name);
    }
}
