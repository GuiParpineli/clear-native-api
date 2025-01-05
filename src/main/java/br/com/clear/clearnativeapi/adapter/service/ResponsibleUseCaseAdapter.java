package br.com.clear.clearnativeapi.adapter.service;

import br.com.clear.clearnativeapi.adapter.mapper.ResponsibleMapper;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.repository.ResponsibleRepository;
import br.com.clear.clearnativeapi.domain.usecase.responsible.ResponsibleUseCase;
import br.com.clear.clearnativeapi.domain.usecase.responsible.ResponsibleUseCaseImpl;
import br.com.clear.clearnativeapi.web.controller.responsible.dto.CreateResponsibleDto;
import br.com.clear.clearnativeapi.web.controller.responsible.dto.ResponsibleDto;
import org.springframework.stereotype.Service;

@Service
public class ResponsibleUseCaseAdapter {
    private final ResponsibleUseCase responsibleUseCase;

    public ResponsibleUseCaseAdapter(ResponsibleRepository repository) {
        this.responsibleUseCase = new ResponsibleUseCaseImpl(repository);
    }

    public ResponsibleDto createResponsible(CreateResponsibleDto dto) {
        Responsible responsible = ResponsibleMapper.toModel(dto);
        return ResponsibleMapper.toDto(responsibleUseCase.createResponsible(responsible));
    }
}
