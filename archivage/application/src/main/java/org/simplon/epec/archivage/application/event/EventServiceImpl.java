package org.simplon.epec.archivage.application.event;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final transient EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public Account createEventAccount(Account account, Event event) {
        return eventRepository.createEventAccount(account, event);
    }

    @Override
    public Contract createEventContract(Contract contract, Event event) {
        return eventRepository.createEventContract(contract, event);
    }

    @Override
    public Set<Event> getEventByType(String eventType) {
        return eventRepository.getEventByType(eventType);
    }

    @Override
    public Set<Event> getEventByClassificationNatureCode(String classificationNatureCode) {
        return eventRepository.getEventByClassificationNatureCode(classificationNatureCode);
    }
}
