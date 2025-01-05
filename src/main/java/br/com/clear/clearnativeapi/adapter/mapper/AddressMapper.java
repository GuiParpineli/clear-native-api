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
                entity.getStreet(),
                entity.getNumber(),
                entity.getCity(),
                entity.getState(),
                entity.getZipCode()
        );
    }
}