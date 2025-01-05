package br.com.clear.clearnativeapi.adapter.service;

import br.com.clear.clearnativeapi.adapter.mapper.CompanyMapper;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.repository.CompanyRepository;
import br.com.clear.clearnativeapi.domain.usecase.company.CompanyUseCase;
import br.com.clear.clearnativeapi.domain.usecase.company.CompanyUseCaseImpl;
import br.com.clear.clearnativeapi.web.controller.company.dto.CompanyRequestDto;
import br.com.clear.clearnativeapi.web.shared.dto.DefaultResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceAdapter {
    private final CompanyUseCase useCase;

    public CompanyServiceAdapter(CompanyRepository repository) {
        this.useCase = new CompanyUseCaseImpl(repository);
    }

    public DefaultResponseDto register(CompanyRequestDto dto) {
        Company company = CompanyMapper.toModel(dto);
        useCase.createCompany(company);
        return new DefaultResponseDto(HttpStatus.CREATED.value(), "Company registered");
    }
}
