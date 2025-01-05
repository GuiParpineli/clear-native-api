package br.com.clear.clearnativeapi.adapter.repository;

import br.com.clear.clearnativeapi.adapter.mapper.ResponsibleMapper;
import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.repository.ResponsibleRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.ResponsibleEntity;
import br.com.clear.clearnativeapi.infrastructure.repository.ResponsibleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ResponsibleRepositoryAdapter implements ResponsibleRepository {
    private final ResponsibleJpaRepository repository;

    public ResponsibleRepositoryAdapter(ResponsibleJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Responsible save(Responsible responsible) {
        ResponsibleEntity entity = ResponsibleMapper.toEntity(responsible);
        return ResponsibleMapper.toModel(repository.save(entity));
    }

    @Override
    public Responsible findById(Long responsibleId) {
        ResponsibleEntity responsibleEntity = repository.findById(responsibleId).orElseThrow();
        return ResponsibleMapper.toModel(responsibleEntity);
    }
}
