package br.com.clear.clearnativeapi.web.controller.responsible.dto;

public record CreateResponsibleDto(
        String name,
        String username,
        String password,
        String email,
        String phone,
        Long companyId
) {
}
