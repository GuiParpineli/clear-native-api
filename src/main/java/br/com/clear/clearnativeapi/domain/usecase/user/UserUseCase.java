package br.com.clear.clearnativeapi.domain.usecase.user;

import br.com.clear.clearnativeapi.infrastructure.entity.UserEntity;

public interface UserUseCase{
    UserEntity loadUserByUsername(String username);
}
