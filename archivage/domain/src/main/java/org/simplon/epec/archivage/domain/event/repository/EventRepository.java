package org.simplon.epec.archivage.domain.event.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.event.entity.Event;

import java.util.Set;

public interface EventRepository {

    Account createEventAccount(Account account, Event event);
    Contract createEventContract(Contract contract, Event event);
    Set<Event> getEventByType(String eventType);
    Set<Event> getEventByClassificationNatureCode(String classificationNatureCode);
}
