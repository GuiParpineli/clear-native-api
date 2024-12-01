package br.com.clear.clearnativeapi.domain.service.account;


import br.com.clear.clearnativeapi.controller.dto.AccountEntityDto;
import br.com.clear.clearnativeapi.domain.model.Account;

public interface AccountUseCase {
    AccountEntityDto createAccount(Account account);

    AccountEntityDto updateAccount(Account account);

    AccountEntityDto getAccountById(Long id);

    void deleteAccount(Long id);
}
