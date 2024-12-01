package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.data.entity.AccountEntity;
import br.com.clear.clearnativeapi.domain.enums.AccountType;
import lombok.Data;

@Data
public class Account {
    private Long id;
    private Integer accountNumber;
    private String accountName;
    private AccountType type;

    public AccountEntity toEntity() {
        return new AccountEntity(id, accountNumber, accountName, type.getDescription());
    }
}
