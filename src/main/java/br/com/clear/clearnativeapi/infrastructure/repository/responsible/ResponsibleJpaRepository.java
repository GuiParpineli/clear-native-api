package br.com.clear.clearnativeapi.infrastructure.repository.responsible;

import br.com.clear.clearnativeapi.infrastructure.entity.ResponsibleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleJpaRepository extends JpaRepository<ResponsibleEntity, Long> {
}
