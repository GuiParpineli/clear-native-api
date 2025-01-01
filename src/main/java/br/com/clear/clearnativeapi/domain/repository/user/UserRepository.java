package br.com.clear.clearnativeapi.domain.repository.user;

import br.com.clear.clearnativeapi.infrastructure.entity.UserEntity;

public interface UserRepository {
    UserEntity findByUsername(String username);
}
