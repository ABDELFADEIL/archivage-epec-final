package org.simplon.epec.archivageElectronique.infrastructure.contract.repository;

import org.simplon.epec.archivageElectronique.domain.contract.repository.ContractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private final transient ContractJpaRepository contractJpaRepository;

    public ContractRepositoryImpl(ContractJpaRepository contractJpaRepository) {
        this.contractJpaRepository = contractJpaRepository;
    }
}
