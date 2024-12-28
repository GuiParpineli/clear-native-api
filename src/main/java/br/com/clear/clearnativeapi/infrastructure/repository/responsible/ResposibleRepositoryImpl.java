package br.com.clear.clearnativeapi.infrastructure.repository.responsible;

import br.com.clear.clearnativeapi.domain.model.Responsible;
import br.com.clear.clearnativeapi.domain.repository.responsible.ResponsibleRepository;
import br.com.clear.clearnativeapi.infrastructure.entity.ResponsibleEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ResposibleRepositoryImpl implements ResponsibleRepository {
    private final ResponsibleJpaRepository repository;

    public ResposibleRepositoryImpl(ResponsibleJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Responsible save(Responsible responsible) {
        return repository.save(ResposibleMapper.toEntity(responsible));
    }
}
