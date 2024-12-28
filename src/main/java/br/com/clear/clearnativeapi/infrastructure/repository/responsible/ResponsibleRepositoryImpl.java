package br.com.clear.clearnativeapi.infrastructure.repository.responsible;

import br.com.clear.clearnativeapi.adapter.mapper.responsible.ResponsibleMapper;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.repository.responsible.ResponsibleRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.ResponsibleEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ResponsibleRepositoryImpl implements ResponsibleRepository {
    private final ResponsibleJpaRepository repository;

    public ResponsibleRepositoryImpl(ResponsibleJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Responsible save(Responsible responsible) {
        ResponsibleEntity entity = ResponsibleMapper.toEntity(responsible);
        return ResponsibleMapper.toModel(repository.save(entity));
    }
}
