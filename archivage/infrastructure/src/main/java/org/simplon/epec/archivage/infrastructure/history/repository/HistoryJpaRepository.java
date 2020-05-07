package org.simplon.epec.archivage.infrastructure.history.repository;

import org.simplon.epec.archivage.domain.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryJpaRepository extends JpaRepository<History, String> {
}
