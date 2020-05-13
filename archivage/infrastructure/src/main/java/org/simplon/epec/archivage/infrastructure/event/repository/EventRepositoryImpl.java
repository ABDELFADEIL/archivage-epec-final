package org.simplon.epec.archivage.infrastructure.event.repository;

import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final transient EventJapRepository eventJapRepository;

    public EventRepositoryImpl(EventJapRepository eventJapRepository) {
        this.eventJapRepository = eventJapRepository;
    }


    @Override
    public Event createEvent(Event event) {
        //////    //// \\\\\\   \\\\\\
        return eventJapRepository.save(event);
    }

    @Override
    public Set<Event> getEventByType(String eventType) {
        return eventJapRepository.findByEvent_type(eventType);
    }

    @Override
    public Set<Event> getEventByClassificationNatureCode(String classificationNatureCode) {
        return eventJapRepository.getEventByClassificationNatureCode(classificationNatureCode);
    }
}
