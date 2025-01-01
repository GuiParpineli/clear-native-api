package br.com.clear.clearnativeapi.adapter.mapper.user;

import br.com.clear.clearnativeapi.domain.model.enums.Role;
import br.com.clear.clearnativeapi.infrastructure.entity.UserEntity;
import br.com.clear.clearnativeapi.domain.model.User;

import java.util.Optional;

public abstract class UserMapper {
    public static UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getRole().name()
        );
    }

    public static User toModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setRole(Role.valueOf(userEntity.getRole()));
        return user;
    }
}
