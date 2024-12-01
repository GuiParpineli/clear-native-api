package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.AccountDto;
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
    public AccountDto toDto() {
        return new AccountDto(id, accountNumber, accountName, type);
    }
}
