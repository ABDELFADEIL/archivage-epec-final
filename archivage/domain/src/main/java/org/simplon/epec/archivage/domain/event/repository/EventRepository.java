package org.simplon.epec.archivage.domain.event.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;

public interface EventRepository {

    Account createEventAccount(Account account);
    Contract createEventContract(Contract contract);
    Client createEventClient(Client client);
}
