package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.AccountEntityDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record AccountEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id,
        Integer accountNumber,
        String accountName,
        String type
) {
    public AccountEntityDto toDto() {
        return new AccountEntityDto(id, accountNumber, accountName, type);
    }
}
