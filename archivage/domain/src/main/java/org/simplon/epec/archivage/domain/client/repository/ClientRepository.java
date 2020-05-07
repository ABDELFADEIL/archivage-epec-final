package org.simplon.epec.archivage.domain.client.repository;

import org.simplon.epec.archivage.domain.client.entity.Client;

public interface ClientRepository {
    
    public Client createClient();
    public Client findOne(String clientID);
}
