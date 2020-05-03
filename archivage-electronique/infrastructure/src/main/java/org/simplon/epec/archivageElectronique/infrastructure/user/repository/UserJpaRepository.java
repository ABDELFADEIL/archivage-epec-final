package org.simplon.epec.archivageElectronique.infrastructure.user.repository;


import org.simplon.epec.archivageElectronique.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, String> {

}
