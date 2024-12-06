package br.com.clear.clearnativeapi.adapter.mapper.responsible;

import br.com.clear.clearnativeapi.adapter.mapper.company.CompanyMapper;
import br.com.clear.clearnativeapi.adapter.mapper.user.UserMapper;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.controller.dto.request.CreateResponsibleDto;
import br.com.clear.clearnativeapi.data.entity.ResponsibleEntity;
import br.com.clear.clearnativeapi.domain.enums.Role;
import br.com.clear.clearnativeapi.domain.model.Company;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.model.User;

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
                responsible.getId(),
                responsible.getName(),
                responsible.getEmail(),
                responsible.getPhone(),
                CompanyMapper.toEntity(responsible.getCompany()),
                responsible.getRole().name(),
                UserMapper.toEntity(responsible.getUser())
        );
    }

    public static Responsible toModel(CreateResponsibleDto dto) {
        return new Responsible(
                dto.name(),
                dto.email(),
                dto.phone(),
                new Company(dto.companyId()),
                Role.USER,
                new User(
                        dto.name(),
                        dto.email(),
                        dto.password()
                )
        );
    }

    public static Responsible toModel(ResponsibleEntity entity) {
        return new Responsible(
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                new Company(entity.getCompany().getId()),
                Role.USER,
                new User(
                        entity.getName(),
                        entity.getEmail(),
                        entity.getUserEntity().getPassword()
                )
        );
    }
}
