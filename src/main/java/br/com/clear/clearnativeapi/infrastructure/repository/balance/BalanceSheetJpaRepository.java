package br.com.clear.clearnativeapi.infrastructure.repository.balance;

import br.com.clear.clearnativeapi.domain.model.BalanceSheet;
import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceSheetJpaRepository extends JpaRepository<BalanceSheetEntity, Long> {
    @Query("select b from BalanceSheetEntity b where b.company = ?1")
    List<BalanceSheet> findAllByCompany(CompanyEntity company);
}
