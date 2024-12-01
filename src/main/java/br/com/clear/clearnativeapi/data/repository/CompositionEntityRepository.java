package br.com.clear.clearnativeapi.data.repository;

import br.com.clear.clearnativeapi.data.entity.CompositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionEntityRepository extends JpaRepository<CompositionEntity, Long> {
}
