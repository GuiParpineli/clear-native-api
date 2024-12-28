package br.com.clear.clearnativeapi.domain.usecase.account;


import br.com.clear.clearnativeapi.domain.model.Account;

public interface AccountUseCase {
    Account createAccount(Account account);

    Account updateAccount(Account account);

    Account getAccountById(Long id);

    void deleteAccount(Long id);
}
