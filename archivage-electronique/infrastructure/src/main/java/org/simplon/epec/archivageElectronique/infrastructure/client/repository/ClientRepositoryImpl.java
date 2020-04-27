package org.simplon.epec.archivageElectronique.infrastructure.client.repository;

import org.simplon.epec.archivageElectronique.domain.client.entity.Client;
import org.simplon.epec.archivageElectronique.domain.client.repository.ClientRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final transient ClientJpaRepository clientJpaRepository;

    public ClientRepositoryImpl(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public Client createClient() {
        return null;
    }

    @Override
    public Client findOne(String clientID) {
        return null;
    }
}
