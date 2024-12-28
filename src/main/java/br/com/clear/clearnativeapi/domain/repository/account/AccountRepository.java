package br.com.clear.clearnativeapi.domain.repository.account;

import br.com.clear.clearnativeapi.domain.model.Account;

public interface AccountRepository {
    Account save(Account account);

    Account update(Account account);

    Account findById(Long id);

    void deleteById(Long id);

}
