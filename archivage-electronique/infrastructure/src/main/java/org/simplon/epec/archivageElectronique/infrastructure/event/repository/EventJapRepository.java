package org.simplon.epec.archivageElectronique.infrastructure.event.repository;

import org.simplon.epec.archivageElectronique.domain.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJapRepository extends JpaRepository<Event, String> {
}
