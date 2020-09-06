package org.simplon.epec.archivage.infrastructure.event.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.simplon.epec.archivage.infrastructure.account.repository.AccountJpaRepository;
import org.simplon.epec.archivage.infrastructure.contract.repository.ContractJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final transient EventJapRepository eventJapRepository;
    private final transient AccountJpaRepository accountJpaRepository;
    private final transient ContractJpaRepository contractJpaRepository;

    public EventRepositoryImpl(EventJapRepository eventJapRepository, AccountJpaRepository accountJpaRepository, ContractJpaRepository contractJpaRepository) {
        this.eventJapRepository = eventJapRepository;
        this.accountJpaRepository = accountJpaRepository;
        this.contractJpaRepository = contractJpaRepository;
    }


    @Override
    public Account createEventAccount(Account account, Event event) {
        Account account1 = accountJpaRepository.findByAccount_number(account.getAccount_number());
        Event event1 = new Event(event.getEvent_type(), event.getEvent_date());
        event1 = eventJapRepository.save(event1);
       // account1.setEvent(event1);
        return accountJpaRepository.save(account1);

    }
    @Override
    public Contract createEventContract(Contract contract, Event event) {
        Contract contract1 = contractJpaRepository.findByContract_number(contract.getContract_number());
        Event event1 = new Event(event.getEvent_type(), event.getEvent_date());
        event1 = eventJapRepository.save(event1);
       // contract.setEvent(event1);
        return contractJpaRepository.save(contract);
    }

    @Override
    public Set<Event> getEventByType(String eventType) {
        return eventJapRepository.findByEvent_type(eventType);
    }


}
