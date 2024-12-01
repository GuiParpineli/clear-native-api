package br.com.clear.clearnativeapi.controller.dto;

import br.com.clear.clearnativeapi.data.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */
public record UserDto(@NotNull @NotEmpty String username,
                      @NotNull @NotEmpty(message = "password cannot be empty") String password) implements Serializable {
}
