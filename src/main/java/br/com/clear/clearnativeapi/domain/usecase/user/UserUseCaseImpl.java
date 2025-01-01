package br.com.clear.clearnativeapi.domain.usecase.user;

import br.com.clear.clearnativeapi.domain.repository.user.UserRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.UserEntity;

public class UserUseCaseImpl implements UserUseCase {
    private final UserRepository repository;

    public UserUseCaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntity loadUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}
