package br.com.clear.clearnativeapi.domain.service.responsible;


import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.controller.dto.request.CreateResponsibleDto;
import br.com.clear.clearnativeapi.domain.model.Responsible;

public interface ResponsibleUseCase {
    ResponsibleDto createResponsible(CreateResponsibleDto responsible);

    ResponsibleDto updateResponsible(Responsible responsible);

    ResponsibleDto getResponsibleById(Long id);

    void deleteResponsible(Long id);
}
