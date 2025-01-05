package br.com.clear.clearnativeapi.adapter.repository;

import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.repository.CompanyRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.AddressEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import br.com.clear.clearnativeapi.infrastructure.repository.AddressJpaRepository;
import br.com.clear.clearnativeapi.infrastructure.repository.CompanyJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import static br.com.clear.clearnativeapi.adapter.mapper.CompanyMapper.toEntity;
import static br.com.clear.clearnativeapi.adapter.mapper.CompanyMapper.toModel;

@Repository
public class CompanyRepositoryAdapter implements CompanyRepository {
    private final CompanyJpaRepository repository;
    private final AddressJpaRepository addressRepository;

    public CompanyRepositoryAdapter(CompanyJpaRepository repository, AddressJpaRepository addressRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    @Override
    public Company save(Company company) {
        CompanyEntity entity = toEntity(company);
        AddressEntity address = addressRepository.save(entity.getAddress());
        entity.setAddress(address);
        return toModel(repository.save(entity));
    }

    @Override
    public Company update(Company company) {
        CompanyEntity entity = toEntity(company);
        return toModel(repository.saveAndFlush(entity));
    }

    @Override
    public Company findById(Long id) {
        return null;
    }
}
