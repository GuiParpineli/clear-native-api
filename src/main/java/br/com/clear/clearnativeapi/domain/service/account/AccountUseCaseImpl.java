package br.com.clear.clearnativeapi.domain.service.account;


import br.com.clear.clearnativeapi.controller.dto.AccountEntityDto;
import br.com.clear.clearnativeapi.data.entity.AccountEntity;
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
    public AccountEntityDto createAccount(Account account) {
        return repository.save(account.toEntity()).toDto();
    }

    @Override
    public AccountEntityDto updateAccount(Account account) {
        return repository.saveAndFlush(account.toEntity()).toDto();
    }

    @Override
    public AccountEntityDto getAccountById(Long id) {
        return repository.findById(id).map(AccountEntity::toDto)
                .orElse(null);
    }

    @Override
    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
