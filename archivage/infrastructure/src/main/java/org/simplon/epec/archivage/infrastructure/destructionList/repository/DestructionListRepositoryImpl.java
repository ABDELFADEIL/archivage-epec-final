package org.simplon.epec.archivage.infrastructure.destructionList.repository;

import org.simplon.epec.archivage.infrastructure.destructionList.repository.DestructionListJpaRepository;
import org.simplon.epec.archivage.domain.destructionList.repository.DestructionListRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DestructionListRepositoryImpl implements DestructionListRepository {

    private final transient DestructionListJpaRepository destructionListJpaRepository;

    public DestructionListRepositoryImpl(DestructionListJpaRepository destructionListJpaRepository) {
        this.destructionListJpaRepository = destructionListJpaRepository;
    }
}
