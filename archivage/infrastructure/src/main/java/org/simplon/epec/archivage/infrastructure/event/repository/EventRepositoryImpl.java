package org.simplon.epec.archivage.infrastructure.event.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.simplon.epec.archivage.infrastructure.account.repository.AccountJpaRepository;
import org.simplon.epec.archivage.infrastructure.client.repository.ClientJpaRepository;
import org.simplon.epec.archivage.infrastructure.context.repository.ContextJpaRepository;
import org.simplon.epec.archivage.infrastructure.contract.repository.ContractJpaRepository;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final transient EventJapRepository eventJapRepository;
    private final transient AccountJpaRepository accountJpaRepository;
    private final transient ContractJpaRepository contractJpaRepository;
    private final transient DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    private final transient ContextJpaRepository contextJpaRepository;
    private final transient ClientJpaRepository clientJpaRepository;

    public EventRepositoryImpl(EventJapRepository eventJapRepository, AccountJpaRepository accountJpaRepository,
                               ContractJpaRepository contractJpaRepository, DigitalDocumentJpaRepository digitalDocumentJpaRepository,
                               ContextJpaRepository contextJpaRepository, ClientJpaRepository clientJpaRepository) {
        this.eventJapRepository = eventJapRepository;
        this.accountJpaRepository = accountJpaRepository;
        this.contractJpaRepository = contractJpaRepository;
        this.digitalDocumentJpaRepository = digitalDocumentJpaRepository;
        this.contextJpaRepository = contextJpaRepository;
        this.clientJpaRepository = clientJpaRepository;
    }


    @Override
    public Account createEventAccount(Account account) {
        List<DigitalDocument> documents = digitalDocumentJpaRepository.getDocsAccountById(account.getAccount_id());
        accountJpaRepository.save(account);
        if (documents.size() > 0) {
            Event event = new Event(account.getStatus());
            final Event event1 = eventJapRepository.save(event);
            documents.forEach(document -> {
                Context context = document.getContext();

                if (context !=null){
                     contextJpaRepository.deleteEven(context.getContext_id());
                     context.setEvent(event1);
                     contextJpaRepository.save(context);
                    } else {
                        context.setEvent(event1);
                        contextJpaRepository.save(context);
                    }


            });
        }
        return accountJpaRepository.findById(account.getAccount_id()).get();
    }

    @Override
    public Contract createEventContract(Contract contract) {
        List<DigitalDocument> documents = digitalDocumentJpaRepository.getDocsContractById(contract.getContract_id());
        contractJpaRepository.save(contract);
        if (documents.size() > 0) {
            Event event = new Event(contract.getStatus());
            final Event event1 = eventJapRepository.save(event);
            documents.forEach(document -> {
                Context context = document.getContext();

                if (context !=null){
                    contextJpaRepository.deleteEven(context.getContext_id());
                    context.setEvent(event1);
                    contextJpaRepository.save(context);
                } else {
                    context.setEvent(event1);
                    contextJpaRepository.save(context);
                }
            });
        }
        return contractJpaRepository.findById(contract.getContract_id()).get();
    }

    @Override
    public Client createEventClient(Client client) {
        List<DigitalDocument> documents = digitalDocumentJpaRepository.findByEventTypeAndClientId(client.getStatus(), client.getClient_id());
        clientJpaRepository.save(client);
        if (documents.size() > 0) {
            Event event = new Event(client.getStatus());
            final Event event1 = eventJapRepository.save(event);
            documents.forEach(document -> {
                Context context = document.getContext();

                if (context !=null){
                    contextJpaRepository.deleteEven(context.getContext_id());
                    context.setEvent(event1);
                    contextJpaRepository.save(context);
                } else {
                    context.setEvent(event1);
                    contextJpaRepository.save(context);
                }
            });
        }
        return clientJpaRepository.findById(client.getClient_id()).get();
    }


}

