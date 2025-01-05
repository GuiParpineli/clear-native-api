package br.com.clear.clearnativeapi.domain.repository;

import br.com.clear.clearnativeapi.infrastructure.entity.UserEntity;

public interface UserRepository {
    UserEntity findByUsername(String username);
}
