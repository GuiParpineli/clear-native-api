package br.com.clear.clearnativeapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 14, unique = true, nullable = false)
    private String cnpj;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 15, nullable = false)
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
