package org.simplon.epec.archivageElectronique.infrastructure.contract.repository;

import org.simplon.epec.archivageElectronique.infrastructure.contract.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractJpaRepository extends JpaRepository<Contract, String> {
}
