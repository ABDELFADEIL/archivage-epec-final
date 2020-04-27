package org.simplon.epec.archivageElectronique.infrastructure.user.repository;

import org.simplon.epec.archivageElectronique.infrastructure.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role, String> {
}
