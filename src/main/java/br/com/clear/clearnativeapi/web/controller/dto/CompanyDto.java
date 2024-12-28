package br.com.clear.clearnativeapi.web.controller.dto;

import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;

import java.io.Serializable;

/**
 * DTO for {@link CompanyEntity}
 */
public record CompanyDto(Long id, String name) implements Serializable {
}
