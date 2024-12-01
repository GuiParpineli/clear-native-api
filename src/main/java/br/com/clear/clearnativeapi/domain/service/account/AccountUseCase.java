package br.com.clear.clearnativeapi.domain.service.account;


import br.com.clear.clearnativeapi.controller.dto.AccountDto;
import br.com.clear.clearnativeapi.domain.model.Account;

public interface AccountUseCase {
    AccountDto createAccount(Account account);

    AccountDto updateAccount(Account account);

    AccountDto getAccountById(Long id);

    void deleteAccount(Long id);
}
