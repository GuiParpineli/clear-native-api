package br.com.clear.clearnativeapi.web.controller.dto.request;

public record CreateResponsibleDto(
        String name,
        String password,
        String email,
        String phone,
        Long companyId
) {
}
