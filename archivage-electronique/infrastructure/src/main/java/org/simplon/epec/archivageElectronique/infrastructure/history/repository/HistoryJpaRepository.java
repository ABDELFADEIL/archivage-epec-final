package org.simplon.epec.archivageElectronique.infrastructure.history.repository;

import org.simplon.epec.archivageElectronique.domain.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryJpaRepository extends JpaRepository<History, String> {
}
