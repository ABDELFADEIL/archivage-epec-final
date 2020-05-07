package org.simplon.epec.archivage.infrastructure.user.repository;

import org.simplon.epec.archivage.domain.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role, String> {
    public Role findByName(String rolename);
}
