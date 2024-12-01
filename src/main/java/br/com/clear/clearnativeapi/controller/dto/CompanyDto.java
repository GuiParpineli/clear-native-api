package br.com.clear.clearnativeapi.controller.dto;

import java.io.Serializable;

/**
 * DTO for {@link br.com.clear.clearnativeapi.data.entity.CompanyEntity}
 */
public record CompanyDto(Long id, String name) implements Serializable {
}
