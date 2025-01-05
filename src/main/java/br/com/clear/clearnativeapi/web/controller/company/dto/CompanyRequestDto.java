package br.com.clear.clearnativeapi.web.controller.company.dto;

import br.com.clear.clearnativeapi.web.controller.dto.AddressDto;

public record CompanyRequestDto(
        String name,
        String cnpj,
        String email,
        String phone,
        AddressDto address
) {
}
