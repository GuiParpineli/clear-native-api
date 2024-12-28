package br.com.clear.clearnativeapi.web.controller.responsible.dto;

public record CreateResponsibleDto(
        String name,
        String password,
        String email,
        String phone,
        Long companyId
) {
}
