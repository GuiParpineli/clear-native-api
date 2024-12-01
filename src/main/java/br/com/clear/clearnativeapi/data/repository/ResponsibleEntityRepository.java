package br.com.clear.clearnativeapi.data.repository;

import br.com.clear.clearnativeapi.data.entity.ResponsibleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleEntityRepository extends JpaRepository<ResponsibleEntity, Long> {
}
