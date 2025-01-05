package br.com.clear.clearnativeapi.adapter.service;

import br.com.clear.clearnativeapi.domain.repository.UserRepository;
import br.com.clear.clearnativeapi.domain.usecase.user.UserUseCase;
import br.com.clear.clearnativeapi.domain.usecase.user.UserUseCaseImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAdapter implements UserDetailsService {
    private final UserUseCase userUseCase;

    public UserServiceAdapter(UserRepository repository) {
        this.userUseCase = new UserUseCaseImpl(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userUseCase.loadUserByUsername(username);
    }
}
