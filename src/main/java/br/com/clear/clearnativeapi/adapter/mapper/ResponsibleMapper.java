package br.com.clear.clearnativeapi.adapter.mapper;

import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.model.User;
import br.com.clear.clearnativeapi.domain.model.enums.Role;
import br.com.clear.clearnativeapi.infrastructure.entity.ResponsibleEntity;
import br.com.clear.clearnativeapi.web.controller.responsible.dto.CreateResponsibleDto;
import br.com.clear.clearnativeapi.web.controller.responsible.dto.ResponsibleDto;

public abstract class ResponsibleMapper {
    public static ResponsibleDto toDto(Responsible responsible) {
        return new ResponsibleDto(
                responsible.getId(),
                responsible.getUser().getUsername(),
                responsible.getUser().getEmail(),
                responsible.getUser().getId(),
                CompanyMapper.toDto(responsible.getCompany())
        );
    }

    public static ResponsibleEntity toEntity(Responsible responsible) {
        return new ResponsibleEntity(
                responsible.getId() == null ? null : responsible.getId(),
                responsible.getName(),
                responsible.getPhone(),
                responsible.getRole().name(),
                CompanyMapper.toEntity(responsible.getCompany()),
                UserMapper.toEntity(responsible.getUser())
        );
    }

    public static Responsible toModel(CreateResponsibleDto dto) {
        return new Responsible(
                dto.name(),
                dto.phone(),
                Role.USER,
                new Company(dto.companyId()),
                new User(
                        null,
                        dto.username(),
                        dto.email(),
                        dto.password(),
                        Role.USER
                )
        );
    }

    public static Responsible toModel(ResponsibleEntity entity) {
        return new Responsible(
                entity.getId() == null ? null : entity.getId(),
                entity.getName(),
                entity.getPhone(),
                Role.USER,
                new Company(entity.getCompany().getId()),
                new User(
                        entity.getId(),
                        entity.getUserEntity().getUsername(),
                        entity.getUserEntity().getEmail(),
                        entity.getUserEntity().getPassword(),
                        Role.valueOf(entity.getRole())
                )
        );
    }
}
