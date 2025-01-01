package br.com.clear.clearnativeapi.domain.model.enums;

import lombok.Getter;

@Getter
public enum AccountType {
    CLIENT("CLIENTE"), SUPPLIER("FORNECEDOR"), OTHER("OUTRO");
    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    public static AccountType of(String description) {
        for (AccountType type : AccountType.values()) {
            if (type.description.equals(description)) return type;
        }
        return null;
    }
}
