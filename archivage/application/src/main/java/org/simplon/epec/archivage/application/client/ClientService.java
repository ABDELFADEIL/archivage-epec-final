package org.simplon.epec.archivage.application.client;

import org.simplon.epec.archivage.domain.client.entity.Client;

import java.util.Set;

public interface ClientService {

    public Client createClient(Client client);
    public Client findOneByCientId(String clientID);
    public Client findOnByClientNumber(String clientNumber);
    public Client UpdateCient(Client client);
    public void removeClient(Client client);
    public Set<Client> getClientsByNameContains(String name);
    public Set<Client> getClientByClientNumberContains(String clientNumber);
    public String createNewClientNumber();
    public Set<Client> findByClientNameOrClientNumberContains(String client_name, String client_number);
}
