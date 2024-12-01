package br.com.clear.clearnativeapi.domain.service.company;


import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.data.repository.CompanyEntityRepository;
import br.com.clear.clearnativeapi.domain.model.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class CompanyUseCaseImpl implements CompanyUseCase {
    private final CompanyEntityRepository repository;

    CompanyUseCaseImpl(CompanyEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<CompanyDto> createCompany(Company company) {
        return Optional.empty();
    }

    @Override
    public Optional<CompanyDto> updateCompany(Company company) {
        return Optional.empty();
    }

    @Override
    public Optional<CompanyDto> getCompanyById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteCompany(Long id) {

    }
}
