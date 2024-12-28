package br.com.clear.clearnativeapi.domain.usecase.address;


import br.com.clear.clearnativeapi.domain.model.Address;

public interface AddressUseCase {
    Address createAddress(Address address);

    Address updateAddress(Address address);

    Address getAddressById(Long id);

    void deleteAddress(Long id);
}
