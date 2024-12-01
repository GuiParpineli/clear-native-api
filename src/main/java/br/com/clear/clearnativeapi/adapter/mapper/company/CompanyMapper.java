package br.com.clear.clearnativeapi.adapter.mapper.company;

import br.com.clear.clearnativeapi.controller.dto.CompanyDto;
import br.com.clear.clearnativeapi.data.entity.CompanyEntity;
import br.com.clear.clearnativeapi.domain.model.Company;

public abstract class CompanyMapper {
    public static CompanyDto toDto(CompanyEntity company) {
        return new CompanyDto(company.getId(), company.getName());
    }

    public static CompanyEntity toEntity(Company companyDto) {
        return new CompanyEntity(companyDto.getId());
    }
}
