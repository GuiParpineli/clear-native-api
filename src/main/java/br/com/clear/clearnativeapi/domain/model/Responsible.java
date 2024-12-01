package br.com.clear.clearnativeapi.domain.model;


import br.com.clear.clearnativeapi.data.entity.ResponsibleEntity;
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

    public Responsible(String name, String email, String phone, Company company, Role role, User user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.role = role;
        this.user = user;
    }

    public ResponsibleEntity toEntity() {
        return new ResponsibleEntity(
                id,
                name,
                email,
                phone,
                company.toEntity(),
                role,
                user.toEntity()
        );
    }
}
