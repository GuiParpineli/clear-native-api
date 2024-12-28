package br.com.clear.clearnativeapi.infrastructure.repository.account;

import br.com.clear.clearnativeapi.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
}
