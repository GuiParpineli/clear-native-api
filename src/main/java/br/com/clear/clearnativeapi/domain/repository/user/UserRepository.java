package br.com.clear.clearnativeapi.domain.repository.user;

import br.com.clear.clearnativeapi.domain.model.User;

public interface UserRepository {
    User findByUsername(String username);
}
