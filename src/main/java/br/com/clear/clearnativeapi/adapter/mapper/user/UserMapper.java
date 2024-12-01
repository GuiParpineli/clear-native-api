package br.com.clear.clearnativeapi.adapter.mapper.user;

import br.com.clear.clearnativeapi.data.entity.UserEntity;
import br.com.clear.clearnativeapi.domain.model.User;

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
}
