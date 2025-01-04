package br.com.clear.clearnativeapi.infrastructure.repository.balance;

import br.com.clear.clearnativeapi.infrastructure.entity.BalanceSheetEntity;
import br.com.clear.clearnativeapi.infrastructure.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceSheetJpaRepository extends JpaRepository<BalanceSheetEntity, Long> {
    @Query("select b from BalanceSheetEntity b where b.company = ?1")
    List<BalanceSheetEntity> findAllByCompany(CompanyEntity company);

    @Query("select b from BalanceSheetEntity b where b.company = ?1 and b.status = ?2")
    List<BalanceSheetEntity> findByStatus(CompanyEntity companyEntity, String status);

    @Query("select b from BalanceSheetEntity  b where b.company.id = ?1 and b.month = ?2 and b.year = ?3")
    List<BalanceSheetEntity> findByMonthAndYear(Long companyId, Integer month, Integer year);

    @Query("select b from BalanceSheetEntity  b where  b.company = ?1 and b.month = ?2")
    List<BalanceSheetEntity> findByMonth(CompanyEntity companyEntity, String month);
}
