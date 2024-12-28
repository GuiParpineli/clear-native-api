package br.com.clear.clearnativeapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@NoArgsConstructor
@Getter
public final class CompanyEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String cnpj;
    private String email;
    private String phone;
    @OneToOne
    private AddressEntity address;

    public CompanyEntity(String name, String cnpj, String email, String phone, AddressEntity address) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public CompanyEntity(Long id) {
        this.id = id;
    }
}
