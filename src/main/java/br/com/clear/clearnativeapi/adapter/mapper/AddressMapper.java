package br.com.clear.clearnativeapi.adapter.mapper;

import br.com.clear.clearnativeapi.domain.model.Address;
import br.com.clear.clearnativeapi.infrastructure.entity.AddressEntity;
import br.com.clear.clearnativeapi.web.controller.dto.AddressDto;

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

    public static Address toModel(AddressEntity entity) {
        return new Address(
                entity.getId(),
                entity.getZipCode(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getCity(),
                entity.getState()
        );
    }

    public static Address toModel(AddressDto address) {
        return new Address(
                0,
                address.zipCode(),
                address.street(),
                address.number(),
                address.city(),
                address.state()
        );
    }

    public static AddressEntity toModel(Address address) {
        return new AddressEntity(
                null,
                address.getZipCode(),
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getState()
        );
    }
}
