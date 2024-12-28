package br.com.clear.clearnativeapi.domain.usecase.company;


import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.web.controller.dto.CompanyDto;

public interface CompanyUseCase {
    Company createCompany(Company company);

    Company updateCompany(Company company);

    Company getCompanyById(Long id);

    void deleteCompany(Long id);
}
