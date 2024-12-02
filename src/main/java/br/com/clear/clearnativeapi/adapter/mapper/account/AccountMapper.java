package br.com.clear.clearnativeapi.adapter.mapper.account;

import br.com.clear.clearnativeapi.controller.dto.AccountDto;
import br.com.clear.clearnativeapi.data.entity.AccountEntity;
import br.com.clear.clearnativeapi.domain.enums.AccountType;
import br.com.clear.clearnativeapi.domain.model.Account;

public abstract class AccountMapper {
    public static AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountName(),
                account.getType().name()
        );
    }

    public static Account toModel(AccountEntity account) {
        return new Account(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountName(),
                AccountType.valueOf(account.getType())
        );
    }
}
