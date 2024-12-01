package br.com.clear.clearnativeapi.data.entity;

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
}
