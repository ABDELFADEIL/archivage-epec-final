package org.simplon.epec.archivageElectronique.infrastructure.client.repository;

import org.simplon.epec.archivageElectronique.infrastructure.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<Client, String> {
    
    public Client createClient();
    public Client findOne(String clientID);
}
