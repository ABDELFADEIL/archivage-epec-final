package org.simplon.epec.archivage.domain.event.repository;

import org.simplon.epec.archivage.domain.event.entity.Event;

import java.util.Set;

public interface EventRepository {

    Event createEvent(Event event);
    Set<Event> getEventByType(String eventType);
    Set<Event> getEventByClassificationNatureCode(String classificationNatureCode);
}
