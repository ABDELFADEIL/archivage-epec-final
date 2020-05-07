package org.simplon.epec.archivage.infrastructure.contract.repository;

import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractJpaRepository extends JpaRepository<Contract, String> {
}
