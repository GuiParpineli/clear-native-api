package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.AddressDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    public AddressDto toDto() {
        return new AddressDto(street, number, city, state, zipCode);
    }
}
