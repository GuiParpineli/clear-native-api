package br.com.clear.clearnativeapi.controller.dto;

import br.com.clear.clearnativeapi.data.entity.ResponsibleEntity;

import java.io.Serializable;

/**
 * DTO for {@link ResponsibleEntity}
 */
public record ResponsibleDto(Long id, String name, String email, CompanyDto company) implements Serializable {
}
