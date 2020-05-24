package org.simplon.epec.archivage.infrastructure.client.repository;

import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.client.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final transient ClientJpaRepository clientJpaRepository;

    public ClientRepositoryImpl(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public Client findOneByCientId(Long clientID) {
        return clientJpaRepository.findById(clientID).get();
    }

    @Override
    public Client findOnByClientNumber(String clientNumber) {
        return clientJpaRepository.findByClientNumber(clientNumber);
    }

    @Override
    public Client UpdateCient(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public Set<Client> getClientsByNameContains(String name) {
        return clientJpaRepository.findByClientNameContains(name);
    }

    @Override
    public Set<Client> getClientByClientNumberContains(String clientNumber) {
        return clientJpaRepository.findByClientNumberContains(clientNumber);
    }


    @Override
    public void removeClient(Client client) {
        clientJpaRepository.delete(client);
    }

    public String getMaxClientNumber(){
      return clientJpaRepository.findMaxClientNumber();
    }
    }
