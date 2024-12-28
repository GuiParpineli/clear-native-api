package br.com.clear.clearnativeapi.domain.usecase.responsible;


import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.repository.responsible.ResponsibleRepository;
import br.com.clear.clearnativeapi.web.controller.responsible.dto.ResponsibleDto;

public class ResponsibleUseCaseImpl implements ResponsibleUseCase {
    private final ResponsibleRepository repository;

    public ResponsibleUseCaseImpl(ResponsibleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Responsible createResponsible(Responsible responsible) {
        return repository.save(responsible);
    }

    @Override
    public ResponsibleDto updateResponsible(Responsible responsible) {
        return null;
    }

    @Override
    public ResponsibleDto getResponsibleById(Long id) {
        return null;
    }

    @Override
    public void deleteResponsible(Long id) {
    }
}
