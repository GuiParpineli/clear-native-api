package br.com.clear.clearnativeapi.adapter.mapper.account;

import br.com.clear.clearnativeapi.web.controller.dto.AccountDto;
import br.com.clear.clearnativeapi.infrastructure.entity.AccountEntity;
import br.com.clear.clearnativeapi.domain.model.enums.AccountType;
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

    public static AccountEntity toEntity(Account account) {
        return new AccountEntity(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountName(),
                account.getType().name()
        );
    }
}
