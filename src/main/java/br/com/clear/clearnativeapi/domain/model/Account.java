package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.domain.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private long id;
    private int accountNumber;
    private String accountName;
    private AccountType type;

    public Account(Long id) {
        this.id = id;
    }
}
