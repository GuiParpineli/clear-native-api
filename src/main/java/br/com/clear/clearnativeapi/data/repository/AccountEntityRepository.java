package br.com.clear.clearnativeapi.data.repository;

import br.com.clear.clearnativeapi.data.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {
}
