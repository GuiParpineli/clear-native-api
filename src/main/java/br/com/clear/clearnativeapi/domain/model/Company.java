package br.com.clear.clearnativeapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
    private Long id;
    private String name;
    private String cnpj;
    private String email;
    private String phone;
    private Address address;

    public Company(Long id) {
        this.id = id;
    }
}
