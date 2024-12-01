package br.com.clear.clearnativeapi.adapter.mapper.address;

import br.com.clear.clearnativeapi.controller.dto.AddressDto;
import br.com.clear.clearnativeapi.domain.model.Address;

public abstract class AddressMapper {
    public static AddressDto toDto(Address address) {
        return new AddressDto(
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getState(),
                address.getZipCode()
        );
    }

    public static Address toEntity(AddressDto addressDto) {
        return new Address(
                null,
                addressDto.street(),
                addressDto.number(),
                addressDto.city(),
                addressDto.state(),
                addressDto.zipCode()
        );
    }
}
