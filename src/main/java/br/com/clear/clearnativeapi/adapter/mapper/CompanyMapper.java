package br.com.clear.clearnativeapi.adapter.mapper;

import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import br.com.clear.clearnativeapi.web.controller.dto.CompanyDto;

public abstract class CompanyMapper {
    public static CompanyDto toDto(Company company) {
        return new CompanyDto(company.getId(), company.getName());
    }

    public static CompanyEntity toEntity(Company companyDto) {
        return new CompanyEntity(companyDto.getId());
    }

    public static Company toModel(CompanyEntity company) {
        return new Company(
                company.getId(),
                company.getName(),
                company.getCnpj(),
                company.getEmail(),
                company.getPhone(),
                AddressMapper.toModel(company.getAddress())
        );
    }
}
