package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.domain.enums.Role;
import lombok.Data;

@Data
public class Responsible {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Company company;
    private Role role;
    private User user;
}
