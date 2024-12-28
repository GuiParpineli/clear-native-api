package br.com.clear.clearnativeapi.adapter.service.responsible;

import br.com.clear.clearnativeapi.adapter.mapper.responsible.ResponsibleMapper;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.repository.responsible.ResponsibleRepository;
import br.com.clear.clearnativeapi.domain.usecase.responsible.ResponsibleUseCase;
import br.com.clear.clearnativeapi.domain.usecase.responsible.ResponsibleUseCaseImpl;
import br.com.clear.clearnativeapi.web.controller.dto.request.CreateResponsibleDto;
import org.springframework.stereotype.Service;

@Service
public class ResponsibleUseCaseAdapter {
    private final ResponsibleUseCase responsibleUseCase;

    public ResponsibleUseCaseAdapter(ResponsibleRepository repository) {
        this.responsibleUseCase = new ResponsibleUseCaseImpl(repository);
    }

    public Responsible createResponsible(CreateResponsibleDto dto) {
        Responsible responsible = ResponsibleMapper.toModel(dto);
        return responsibleUseCase.createResponsible(responsible);
    }
}
