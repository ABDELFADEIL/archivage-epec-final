package org.simplon.epec.archivage.infrastructure.event.repository;

import org.simplon.epec.archivage.domain.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJapRepository extends JpaRepository<Event, String> {
}
