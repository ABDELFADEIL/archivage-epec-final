package org.simplon.epec.archivage.infrastructure.context.repository;

import org.simplon.epec.archivage.infrastructure.contract.repository.ContractJpaRepository;
import org.simplon.epec.archivage.domain.document.repository.ContextRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContextRepositoryImpl implements ContextRepository {

    private final transient ContractJpaRepository contractJpaRepository;

    public ContextRepositoryImpl(ContractJpaRepository contractJpaRepository) {
        this.contractJpaRepository = contractJpaRepository;
    }
}
