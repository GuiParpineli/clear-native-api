package br.com.clear.clearnativeapi.adapter.mapper.company;

import br.com.clear.clearnativeapi.adapter.mapper.address.AddressMapper;
import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.domain.model.Company;

public abstract class CompanyMapper {
    public static CompanyDto toDto(Company company) {
        return new CompanyDto(company.getId(), company.getName());
    }

    public static Company toEntity(CompanyDto companyDto) {
        return new Company(companyDto.id());
    }
}
