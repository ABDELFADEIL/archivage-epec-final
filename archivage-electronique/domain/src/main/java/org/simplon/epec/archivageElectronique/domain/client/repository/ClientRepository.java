package org.simplon.epec.archivageElectronique.domain.client.repository;

import org.simplon.epec.archivageElectronique.domain.client.entity.Client;

public interface ClientRepository {
    
    public Client createClient();
    public Client findOne(String clientID);
}
