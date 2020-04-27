package org.simplon.epec.archivageElectronique.infrastructure.document.repository;

import org.simplon.epec.archivageElectronique.domain.document.repository.ContextRepository;
import org.simplon.epec.archivageElectronique.infrastructure.contract.repository.ContractJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContextRepositoryImpl implements ContextRepository {

    private final transient ContractJpaRepository contractJpaRepository;

    public ContextRepositoryImpl(ContractJpaRepository contractJpaRepository) {
        this.contractJpaRepository = contractJpaRepository;
    }
}
