package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.domain.model.enums.Role;
import lombok.Data;

@Data
public class Responsible {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;
    private Company company;
    private User user;

    public Responsible(String name, String email, String phone, Role role, Company company, User user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.company = company;
        this.user = user;
    }

    public Responsible(Long id) {
        this.id = id;
    }
}
