package br.com.clear.clearnativeapi.controller.dto.request;

public record CreateResponsibleDto(
        String name,
        String password,
        String email,
        String phone,
        Long companyId
) {
}
