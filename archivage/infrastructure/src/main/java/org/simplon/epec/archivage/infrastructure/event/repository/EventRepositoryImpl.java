package org.simplon.epec.archivage.infrastructure.event.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.simplon.epec.archivage.infrastructure.account.repository.AccountJpaRepository;
import org.simplon.epec.archivage.infrastructure.contract.repository.ContractJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final transient EventJapRepository eventJapRepository;
    private final transient AccountJpaRepository accountJpaRepository;
    private final transient ContractJpaRepository contractJpaRepository;
    private final transient ClassificationNatureRepository classificationNatureRepository;

    public EventRepositoryImpl(EventJapRepository eventJapRepository, AccountJpaRepository accountJpaRepository, ContractJpaRepository contractJpaRepository, ClassificationNatureRepository classificationNatureRepository) {
        this.eventJapRepository = eventJapRepository;
        this.accountJpaRepository = accountJpaRepository;
        this.contractJpaRepository = contractJpaRepository;
        this.classificationNatureRepository = classificationNatureRepository;
    }


    @Override
    public Account createEventAccount(Account account, Event event) {
        Account account1 = accountJpaRepository.findByAccount_number(account.getAccount_number());
        List<DigitalDocument> documentList = (List<DigitalDocument>) account1.getDigitalDocuments();
        String classification_nature_id = documentList.get(0).getContext().getClassification_nature_id();
        ClassificationNature classificationNature = classificationNatureRepository.findById(classification_nature_id);
        Event event1 = new Event(event.getEvent_type(), classificationNature, event.getEvent_date());
        event1 = eventJapRepository.save(event1);
        account1.setEvent(event1);
        return accountJpaRepository.save(account1);

    }
    @Override
    public Contract createEventContract(Contract contract, Event event) {
        Contract contract1 = contractJpaRepository.findByContract_number(contract.getContract_number());
        List<DigitalDocument> documentList = (List<DigitalDocument>) contract1.getDigitalDocuments();
        String classification_nature_id = documentList.get(0).getContext().getClassification_nature_id();
        ClassificationNature classificationNature = classificationNatureRepository.findById(classification_nature_id);
        Event event1 = new Event(event.getEvent_type(), classificationNature, event.getEvent_date());
        event1 = eventJapRepository.save(event1);
        contract.setEvent(event1);
        return contractJpaRepository.save(contract);
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
