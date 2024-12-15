package br.com.clear.clearnativeapi.domain.service.account;


import br.com.clear.clearnativeapi.adapter.mapper.account.AccountMapper;
import br.com.clear.clearnativeapi.data.repository.AccountEntityRepository;
import br.com.clear.clearnativeapi.domain.model.Account;
import org.springframework.stereotype.Service;

@Service
class AccountUseCaseImpl implements AccountUseCase {
    private final AccountEntityRepository repository;

    AccountUseCaseImpl(AccountEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account createAccount(Account account) {
        return AccountMapper.toModel(repository.save(AccountMapper.toEntity(account)));
    }

    @Override
    public Account updateAccount(Account account) {
        return AccountMapper.toModel(repository.saveAndFlush(AccountMapper.toEntity(account)));
    }

    @Override
    public Account getAccountById(Long id) {
        return repository.findById(id).map(AccountMapper::toModel).orElse(null);
    }

    @Override
    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
