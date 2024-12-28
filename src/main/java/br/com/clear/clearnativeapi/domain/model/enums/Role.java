package br.com.clear.clearnativeapi.domain.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    USER("user"), ADMIN("admin"), SUPER_ADMIN("superAdmin");
    private final String description;

    Role(String description) {
        this.description = description;
    }
}
