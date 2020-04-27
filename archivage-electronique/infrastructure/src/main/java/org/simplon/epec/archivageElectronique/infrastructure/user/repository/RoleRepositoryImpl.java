package org.simplon.epec.archivageElectronique.infrastructure.user.repository;

import org.simplon.epec.archivageElectronique.domain.user.repository.RoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final transient RoleJpaRepository roleJpaRepository;

    public RoleRepositoryImpl(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }
}
