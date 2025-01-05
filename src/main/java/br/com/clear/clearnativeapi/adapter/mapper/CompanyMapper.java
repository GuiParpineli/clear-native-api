package br.com.clear.clearnativeapi.adapter.mapper;

import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import br.com.clear.clearnativeapi.web.controller.company.dto.CompanyRequestDto;
import br.com.clear.clearnativeapi.web.controller.dto.CompanyDto;

public abstract class CompanyMapper {
    public static CompanyDto toDto(Company company) {
        return new CompanyDto(company.getId(), company.getName());
    }

    public static CompanyEntity toEntity(Company company) {
        return new CompanyEntity(
                company.getId() == null ? null : company.getId(),
                company.getName(),
                company.getCnpj(),
                company.getEmail(),
                company.getPhone(),
                AddressMapper.toEntity(company.getAddress())
        );
    }

    public static CompanyEntity toEntity(Long companyId) {
        return new CompanyEntity(companyId);
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

    public static Company toModel(CompanyRequestDto dto) {
        return new Company(
                null,
                dto.name(),
                dto.cnpj(),
                dto.email(),
                dto.phone(),
                AddressMapper.toModel(dto.address())
        );
    }
}
