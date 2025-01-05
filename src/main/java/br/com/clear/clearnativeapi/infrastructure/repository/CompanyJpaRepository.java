package br.com.clear.clearnativeapi.infrastructure.repository;

import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {
}
