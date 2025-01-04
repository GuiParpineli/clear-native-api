package br.com.clear.clearnativeapi.domain.model.enums;

public enum Role {
    USER,
    ADMIN,
    SUPER_ADMIN;

    public boolean isAdminOrSuper() {
        return this == ADMIN || this == SUPER_ADMIN;
    }
}
