package br.com.clear.clearnativeapi.data.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record UserDto(@NotNull @NotEmpty String username,
                      @NotNull @NotEmpty(message = "password cannot be empty") String password) implements Serializable {
}
