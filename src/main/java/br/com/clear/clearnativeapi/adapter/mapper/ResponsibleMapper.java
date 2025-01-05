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
                responsible.getName(),
                responsible.getEmail(),
                responsible.getUser().getId(),
                CompanyMapper.toDto(responsible.getCompany())
        );
    }

    public static ResponsibleEntity toEntity(Responsible responsible) {
        return new ResponsibleEntity(
                responsible.getId() == null ? null : responsible.getId(),
                responsible.getName(),
                responsible.getEmail(),
                responsible.getPhone(),
                responsible.getRole().name(),
                CompanyMapper.toEntity(responsible.getCompany()),
                UserMapper.toEntity(responsible.getUser())
        );
    }

    public static Responsible toModel(CreateResponsibleDto dto) {
        return new Responsible(
                dto.name(),
                dto.email(),
                dto.phone(),
                Role.USER,
                new Company(dto.companyId()),
                new User(
                        0L,
                        dto.name(),
                        dto.email(),
                        dto.password(),
                        Role.USER
                )
        );
    }

    public static Responsible toModel(ResponsibleEntity entity) {
        return new Responsible(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                Role.USER,
                new Company(entity.getCompany().getId()),
                new User(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getUserEntity().getPassword(),
                        Role.valueOf(entity.getRole())
                )
        );
    }
}
