package br.com.clear.clearnativeapi.web.controller.dto;

import br.com.clear.clearnativeapi.infrastructure.entity.ResponsibleEntity;

import java.io.Serializable;

/**
 * DTO for {@link ResponsibleEntity}
 */
public record ResponsibleDto(Long id, String name, String email, Long userId,
                             CompanyDto company) implements Serializable {
}
