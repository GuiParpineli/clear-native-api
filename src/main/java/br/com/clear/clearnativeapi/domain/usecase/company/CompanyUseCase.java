package br.com.clear.clearnativeapi.domain.usecase.company;


import br.com.clear.clearnativeapi.domain.model.Company;

public interface CompanyUseCase {
    void createCompany(Company company);

    Company updateCompany(Company company);

    Company getCompanyById(Long id);

    void deleteCompany(Long id);
}
