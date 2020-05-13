package org.simplon.epec.archivage.infrastructure.event.repository;

import org.simplon.epec.archivage.domain.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EventJapRepository extends JpaRepository<Event, String> {
    Set<Event> findByEvent_type(String eventType);
    Set<Event> getEventByClassificationNatureCode(String classificationNatureCode);
}
