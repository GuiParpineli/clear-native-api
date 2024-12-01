package br.com.clear.clearnativeapi.adapter.mapper.responsible;

import br.com.clear.clearnativeapi.adapter.mapper.company.CompanyMapper;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.domain.model.Responsible;

public abstract class RessponsibleMapper {
    public static ResponsibleDto toDto(Responsible responsible) {
        return new ResponsibleDto(
                responsible.getId(),
                responsible.getName(),
                responsible.getEmail(),
                UserMapper.toDto(responsible.getUser()),
                CompanyMapper.toDto(responsible.getCompany())
        );
    }

    public static Responsible toEntity(ResponsibleDto responsibleDto) {
        return new Responsible(
                responsibleDto.name(),
                responsibleDto.email(),
                responsibleDto.phone,
                CompanyMapper.toEntity(responsibleDto.company()),
                responsibleDto.role(),
                responsibleDto.user()
        );
    }
}
