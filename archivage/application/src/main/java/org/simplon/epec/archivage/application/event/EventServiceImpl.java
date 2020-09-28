package org.simplon.epec.archivage.application.event;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final transient EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public Account createEventAccount(Account account) {
        return eventRepository.createEventAccount(account);
    }

    @Override
    public Contract createEventContract(Contract contract) {
        return eventRepository.createEventContract(contract);
    }

    @Override
    public Client createEventClient(Client client) {
        return eventRepository.createEventClient(client);
    }

    @Override
    public Event createEvent(String event_type) {
        return eventRepository.createEvent(event_type);
    }


}
