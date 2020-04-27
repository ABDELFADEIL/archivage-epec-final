package org.simplon.epec.archivageElectronique.infrastructure.event.repository;

import org.simplon.epec.archivageElectronique.domain.event.repository.EventRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final transient EventJapRepository eventJapRepository;

    public EventRepositoryImpl(EventJapRepository eventJapRepository) {
        this.eventJapRepository = eventJapRepository;
    }
}
