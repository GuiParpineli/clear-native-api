package br.com.clear.clearnativeapi.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record AddressEntity(
        @Id
        @GeneratedValue
        Long id,
        String street,
        String number,
        String city,
        String state,
        String zipCode
) {
}
