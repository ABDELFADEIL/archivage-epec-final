package org.simplon.epec.archivage.application.client;

import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.client.repository.ClientRepository;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final transient ClientRepository clientRepository;
    private final transient UserRepository userRepository;



    public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Client createClient(Client client) {
        ////////////// code logic
        String client_number = createNewClientNumber();
        User user = userRepository.getAuthenticatedUser();
        int clientNatureId = client.getClient_nature_id();
        int civilityId = client.getCivility_id();
        Client c = new Client( clientNatureId,  client_number,  client.getClient_name(), client.getClient_first_name(), civilityId, client.getBirth_date(),
                client.getBirth_dept(), client.getSiren_number(), client.getSiret_number(), user.getUser_id());
        return clientRepository.createClient(c);
    }

    @Override
    public Client UpdateCient(Client client) {
        return clientRepository.UpdateCient(client);
    }

    @Override
    public Client findOneByCientId(String clientID) {
        return clientRepository.findOneByCientId(clientID);
    }

    @Override
    public Client findOnByClientNumber(String clientNumber) {
        Client client = null;
        try {
            client = clientRepository.findOnByClientNumber(clientNumber);
        }catch (Exception e){
            System.out.print("error message .... "+e.getMessage());
        }
       return client;
    }

    @Override
    public Set<Client> getClientsByNameContains(String name) {
        return clientRepository.getClientsByNameContains(name);
    }

    @Override
    public Set<Client> getClientByClientNumberContains(String clientNumber) {
        return clientRepository.getClientByClientNumberContains(clientNumber);
    }

    @Override
    public void removeClient(Client client) {
        clientRepository.removeClient(client);
    }

    @Override
    public String createNewClientNumber(){

        String client_number_pre = clientRepository.getMaxClientNumber();
        if (client_number_pre==null){
            return "000000000001";
        }
        long number_account =  Long.parseLong(client_number_pre);
        long new_number_account = number_account + 1;
        String client_number_nex = "00000000000".substring(String.valueOf(new_number_account).length()+1)+new_number_account;
        return client_number_nex;
    }

    @Override
    public Set<Client> findByClientNameOrClientNumberContains(String client_name, String client_number) {
        return clientRepository.findByClientNameOrClientNumberContains(client_name, client_number);
    }
}
