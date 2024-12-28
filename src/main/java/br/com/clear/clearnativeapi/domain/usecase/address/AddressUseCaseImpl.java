package br.com.clear.clearnativeapi.domain.usecase.address;


import br.com.clear.clearnativeapi.domain.model.Address;
import br.com.clear.clearnativeapi.domain.repository.address.AddressRepository;

class AddressUseCaseImpl implements AddressUseCase {
    private final AddressRepository repository;

    AddressUseCaseImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address createAddress(Address address) {
        return repository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return repository.update(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteAddress(Long id) {
        repository.delete(id);
    }
}
