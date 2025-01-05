package br.com.clear.clearnativeapi.infrastructure.repository;

import br.com.clear.clearnativeapi.infrastructure.entity.CompositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionJpaRepository extends JpaRepository<CompositionEntity, Long> {
}
