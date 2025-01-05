package br.com.clear.clearnativeapi.adapter.repository;

import br.com.clear.clearnativeapi.domain.repository.UserRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.UserEntity;
import br.com.clear.clearnativeapi.infrastructure.repository.UserJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository repository;

    public UserRepositoryAdapter(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow();
    }
}
