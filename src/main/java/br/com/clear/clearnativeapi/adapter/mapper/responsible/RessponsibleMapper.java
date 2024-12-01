package br.com.clear.clearnativeapi.adapter.mapper.responsible;

import br.com.clear.clearnativeapi.adapter.mapper.company.CompanyMapper;
import br.com.clear.clearnativeapi.adapter.mapper.user.UserMapper;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.data.entity.ResponsibleEntity;
import br.com.clear.clearnativeapi.domain.model.Responsible;

public abstract class RessponsibleMapper {
    public static ResponsibleDto toDto(ResponsibleEntity responsible) {
        return new ResponsibleDto(
                responsible.getId(),
                responsible.getName(),
                responsible.getEmail(),
                responsible.getUserEntity().getId(),
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
}
