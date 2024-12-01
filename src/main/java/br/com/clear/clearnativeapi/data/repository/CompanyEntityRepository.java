package br.com.clear.clearnativeapi.data.repository;

import br.com.clear.clearnativeapi.data.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEntityRepository extends JpaRepository<CompanyEntity, Long> {
}
