package br.com.clear.clearnativeapi.domain.model;

import lombok.Data;

@Data
public class Company {
    private Long id;
    private String name;
    private String cnpj;
    private String email;
    private String phone;
    private Address address;
}
