package br.com.clear.clearnativeapi.controller.dto;

import java.io.Serializable;

/**
 * DTO for {@link br.com.clear.clearnativeapi.data.entity.AddressEntity}
 */
public record AddressDto(String street, String number, String city, String state,
                         String zipCode) implements Serializable {
}
