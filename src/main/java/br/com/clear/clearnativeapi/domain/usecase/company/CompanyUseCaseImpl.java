package br.com.clear.clearnativeapi.domain.usecase.company;


import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.repository.CompanyRepository;

public class CompanyUseCaseImpl implements CompanyUseCase {
    private final CompanyRepository repository;

    CompanyUseCaseImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company createCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        return repository.update(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteCompany(Long id) {

    }
}
