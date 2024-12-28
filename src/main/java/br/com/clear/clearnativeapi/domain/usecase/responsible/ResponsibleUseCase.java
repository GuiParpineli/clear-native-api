package br.com.clear.clearnativeapi.domain.usecase.responsible;


import br.com.clear.clearnativeapi.web.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.domain.model.Responsible;

public interface ResponsibleUseCase {
    Responsible createResponsible(Responsible responsible);

    ResponsibleDto updateResponsible(Responsible responsible);

    ResponsibleDto getResponsibleById(Long id);

    void deleteResponsible(Long id);
}
