package br.com.clear.clearnativeapi.domain.service.company;


import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.domain.model.Company;

import java.util.Optional;

public interface CompanyUseCase {
    Optional<CompanyDto> createCompany(Company company);

    Optional<CompanyDto> updateCompany(Company company);

    Optional<CompanyDto> getCompanyById(Long id);

    void deleteCompany(Long id);
}
