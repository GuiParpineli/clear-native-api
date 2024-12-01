package br.com.clear.clearnativeapi.domain.enums;

import lombok.Getter;

@Getter
public enum AccountType {
    CLIENT("CLIENTE"), SUPPLIER("FORNECEDOR"), OTHER("OUTRO");
    private final String description;

    AccountType(String description) {
        this.description = description;
    }
}
