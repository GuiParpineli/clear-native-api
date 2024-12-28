package br.com.clear.clearnativeapi.domain.usecase.user;

import br.com.clear.clearnativeapi.domain.model.User;
import br.com.clear.clearnativeapi.domain.repository.user.UserRepository;

public class UserUseCaseImpl implements UserUseCase {
    private final UserRepository repository;

    public UserUseCaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User loadUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}
