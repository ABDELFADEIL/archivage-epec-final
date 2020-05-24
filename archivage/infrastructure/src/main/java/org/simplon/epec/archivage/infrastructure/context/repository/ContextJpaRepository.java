package org.simplon.epec.archivage.infrastructure.context.repository;

import org.simplon.epec.archivage.domain.document.entity.Context;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContextJpaRepository extends JpaRepository<Context, Long> {
}
