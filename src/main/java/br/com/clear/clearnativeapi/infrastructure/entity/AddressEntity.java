package br.com.clear.clearnativeapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 9)
    private int zipCode;
    @Column(nullable = false, length = 100)
    private String street;
    @Column(nullable = false, length = 10)
    private String number;
    @Column(nullable = false, length = 50)
    private String city;
    @Column(nullable = false, length = 3)
    private String state;
}
