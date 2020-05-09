package org.simplon.epec.archivage.domain.client.repository;

import org.simplon.epec.archivage.domain.client.entity.Client;

import java.util.Collection;
import java.util.Set;

public interface ClientRepository {
    
     Client createClient(Client client);
     Client findOneByCientId(String clientID);
     Client findOnByClientNumber(String clientNumber);
     Client UpdateCient(Client client);
     void removeClient(Client client);
     Set<Client> getClientsByNameContains(String name);
     Set<Client> getClientByClientNumberContains(String clientNumber);
     String getMaxClientNumber();
}
