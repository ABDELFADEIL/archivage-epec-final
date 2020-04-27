package org.simplon.epec.archivageElectronique.infrastructure.user.repository;

import org.simplon.epec.archivageElectronique.domain.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final transient UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }
}
