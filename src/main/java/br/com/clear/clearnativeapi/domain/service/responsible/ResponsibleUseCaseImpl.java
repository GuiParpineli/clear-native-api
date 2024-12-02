package br.com.clear.clearnativeapi.domain.service.responsible;


import br.com.clear.clearnativeapi.adapter.mapper.responsible.ResponsibleMapper;
import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import br.com.clear.clearnativeapi.data.repository.ResponsibleEntityRepository;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import org.springframework.stereotype.Service;


@Service
class ResponsibleUseCaseImpl implements ResponsibleUseCase {
    private final ResponsibleEntityRepository repository;

    ResponsibleUseCaseImpl(ResponsibleEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Responsible createResponsible(Responsible responsible) {
        return ResponsibleMapper.toModel(repository.save(ResponsibleMapper.toEntity(responsible)));
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
