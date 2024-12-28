package br.com.clear.clearnativeapi.domain.repository.company;

import br.com.clear.clearnativeapi.domain.model.Company;

public interface CompanyRepository {
    Company save(Company company);

    Company update(Company company);

    Company findById(Long id);
}
