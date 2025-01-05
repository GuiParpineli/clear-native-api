package br.com.clear.clearnativeapi.domain.repository;

import br.com.clear.clearnativeapi.domain.model.Address;

public interface AddressRepository {
    Address save(Address address);

    Address update(Address address);

    Address findById(Long id);

    void delete(Long id);
}
