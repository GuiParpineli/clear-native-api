package br.com.clear.clearnativeapi.data.repository;

import br.com.clear.clearnativeapi.data.entity.BalanceSheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceSheetEntityRepository extends JpaRepository<BalanceSheetEntity, Long> {
}
