package br.com.clear.clearnativeapi.controller.dto.request;

import br.com.clear.clearnativeapi.domain.enums.Role;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.model.User;

public record CreateResponsibleDto(
        String name,
        String password,
        String email,
        String phone,
        Long companyId
) {
    public Responsible toModel() {
        return new Responsible(
                this.name,
                this.email,
                this.phone,
                new Company(companyId),
                Role.USER,
                new User(
                        this.name,
                        this.email,
                        this.password
                )
        );
    }
}
