package br.com.clear.clearnativeapi.domain.usecase.account;


import br.com.clear.clearnativeapi.domain.model.Account;
import br.com.clear.clearnativeapi.domain.repository.account.AccountRepository;

class AccountUseCaseImpl implements AccountUseCase {
    private final AccountRepository repository;

    AccountUseCaseImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return repository.update(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
