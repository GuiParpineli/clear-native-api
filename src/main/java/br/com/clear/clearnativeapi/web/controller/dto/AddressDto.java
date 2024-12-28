package br.com.clear.clearnativeapi.web.controller.dto;

import br.com.clear.clearnativeapi.infrastructure.entity.AddressEntity;

import java.io.Serializable;

/**
 * DTO for {@link AddressEntity}
 */
public record AddressDto(String street, String number, String city, String state,
                         String zipCode) implements Serializable {
}
