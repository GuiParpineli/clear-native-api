package br.com.clear.clearnativeapi.domain.service.address;


import br.com.clear.clearnativeapi.data.entity.AddressEntity;

public interface AddressUseCase {
    AddressEntity createAddress(AddressEntity address);

    AddressEntity updateAddress(AddressEntity address);

    AddressEntity getAddressById(Long id);

    void deleteAddress(Long id);
}
