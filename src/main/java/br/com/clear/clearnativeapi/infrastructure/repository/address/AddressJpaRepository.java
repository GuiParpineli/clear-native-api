package br.com.clear.clearnativeapi.infrastructure.repository.address;

import br.com.clear.clearnativeapi.infrastructure.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {
}
