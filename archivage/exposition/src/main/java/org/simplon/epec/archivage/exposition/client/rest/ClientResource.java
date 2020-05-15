package org.simplon.epec.archivage.exposition.client.rest;

import org.simplon.epec.archivage.application.client.ClientService;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Set;

@RestController
@RequestMapping("/api/clients")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("create-new-client")
    public Client createClient(@RequestBody(required = true) Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("get-client-id")
    public Client findOneByCientId(@RequestParam(name = "clientID",  required = true) String clientID) {
        return clientService.findOneByCientId(clientID);
    }

    @GetMapping("get-client-number")
    public ResponseEntity<Client> findOnByClientNumber(@RequestParam(name = "clientNumber", required = true) String clientNumber) {
        Client client = clientService.findOnByClientNumber(clientNumber);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PutMapping("update-client")
    public Client UpdateCient(@RequestBody(required = true) Client client) {
        return clientService.UpdateCient(client);
    }

    @DeleteMapping("/remove-client")
    public void removeClient(@RequestBody(required = true) Client client) {
        clientService.removeClient(client);
    }

    @GetMapping("/get-clients-name-mc")
    public Set<Client> getClientsByNameContains(@RequestParam(name = "name", required = true) String name) {
        return clientService.getClientsByNameContains(name);
    }

    @GetMapping("/get-clients-number-mc")
    public Set<Client> getClientByClientNumberContains(@RequestParam(name="clientNumber", required = true) String clientNumber) {
        return clientService.getClientByClientNumberContains(clientNumber);
    }
}
