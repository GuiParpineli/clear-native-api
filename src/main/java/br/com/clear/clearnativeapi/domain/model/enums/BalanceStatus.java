package br.com.clear.clearnativeapi.domain.model.enums;

import lombok.Getter;

@Getter
public enum BalanceStatus {
    OPEN("ABERTO"),
    PROGRESS("EM ANDAMENTO"),
    PENDENT_REOPEN("PENDENTE REABERTURA"),
    CLOSED("FINALIZADO");

    private final String description;

    BalanceStatus(String description) {
        this.description = description;
    }

    public static BalanceStatus of(String description) {
        for (BalanceStatus status : BalanceStatus.values()) {
            if (status.description.equals(description)) return status;
        }
        return null;
    }

}
