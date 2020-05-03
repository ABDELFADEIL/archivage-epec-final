package org.simplon.epec.archivageElectronique.infrastructure.document.repository;

import org.simplon.epec.archivageElectronique.domain.document.entity.Context;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContextJpaRepository extends JpaRepository<Context, String> {
}
