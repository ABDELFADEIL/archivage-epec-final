package org.simplon.epec.archivage.exposition.event.rest;

import org.simplon.epec.archivage.application.account.AccountService;
import org.simplon.epec.archivage.application.contract.ContractService;
import org.simplon.epec.archivage.application.event.EventService;
import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventResource {

    private final transient AccountService accountService;
    private final transient ContractService contractService;
    private final transient EventService eventService;

    public EventResource(AccountService accountService, ContractService contractService, EventService eventService) {
        this.accountService = accountService;
        this.contractService = contractService;
        this.eventService = eventService;
    }


    @PostMapping("/create-event-account")
    public Account createEventAccount(@RequestBody Account account){
        Event event = account.getEvent();
        return eventService.createEventAccount(account, event);
    }


    @PostMapping("/create-event-contract")
    public Contract createEventContract(@RequestBody Contract contract){
        Event event = contract.getEvent();
        return eventService.createEventContract(contract, event);
    }
}
