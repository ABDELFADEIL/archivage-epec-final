package org.simplon.epec.archivage.infrastructure.user.repository;

import org.simplon.epec.archivage.domain.user.entity.Role;
import org.simplon.epec.archivage.domain.user.repository.RoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final transient RoleJpaRepository roleJpaRepository;

    public RoleRepositoryImpl(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }

    @Override
    public Role findByName(String rolename) {
        return roleJpaRepository.findByName(rolename);
    }

    @Override
    public Role saveRole(Role role) {
        return roleJpaRepository.save(role);
    }
}
