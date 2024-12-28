package br.com.clear.clearnativeapi.domain.usecase.user;

import br.com.clear.clearnativeapi.domain.model.User;

public interface UserUseCase{
    User loadUserByUsername(String username);
}
