package br.com.clear.clearnativeapi.domain.model;

import br.com.clear.clearnativeapi.domain.model.enums.Role;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
