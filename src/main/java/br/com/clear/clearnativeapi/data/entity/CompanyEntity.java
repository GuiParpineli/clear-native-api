package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "company")
@AllArgsConstructor
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

    public CompanyEntity(Long id) {
        this.id = id;
    }
}
