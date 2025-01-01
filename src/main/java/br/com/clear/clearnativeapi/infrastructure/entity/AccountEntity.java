package br.com.clear.clearnativeapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private int accountNumber;
    @Column(length = 50, nullable = false)
    private String accountName;
    @Column(length = 15, nullable = false)
    private String type;

    public AccountEntity(Long id) {
        this.id = id;
    }
}
