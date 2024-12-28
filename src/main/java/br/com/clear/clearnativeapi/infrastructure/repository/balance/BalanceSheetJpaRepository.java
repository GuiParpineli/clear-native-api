package br.com.clear.clearnativeapi.infrastructure.repository.balance;

import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceSheetJpaRepository extends JpaRepository<BalanceSheetEntity, Long> {
}
