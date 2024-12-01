package br.com.clear.clearnativeapi.domain.service.address;


import br.com.clear.clearnativeapi.data.entity.AddressEntity;
import br.com.clear.clearnativeapi.data.repository.AddressEntityRepository;
import org.springframework.stereotype.Service;

@Service
class AddressUseCaseImpl implements AddressUseCase {
    private final AddressEntityRepository repository;

    AddressUseCaseImpl(AddressEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public AddressEntity createAddress(AddressEntity address) {
        return null;
    }

    @Override
    public AddressEntity updateAddress(AddressEntity address) {
        return null;
    }

    @Override
    public AddressEntity getAddressById(Long id) {
        return null;
    }

    @Override
    public void deleteAddress(Long id) {

    }
}
