package org.simplon.epec.archivage.exposition.client.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.simplon.epec.archivage.application.client.ClientService;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    // headers = {"content-type=multipart/form-data;boundary=----WebKitFormBoundaryOJAXpJeIgZ33GbTJ"},
    // consumes = {"multipart/form-data;boundary=----WebKitFormBoundaryoHxquTVoEekJwWSy", "application/mixed;charset=UTF-8", MediaType.APPLICATION_OCTET_STREAM_VALUE},produces="applcation/json"
    @PostMapping(value = "/new-client-with-docs", consumes = {"multipart/form-data;boundary=----WebKitFormBoundaryGU19yc6e19LFwvk2"})
    public ResponseEntity<Void> createClientWithdocs(
            @RequestPart("client") String client,
             @RequestPart("files") MultipartFile  [] files) throws IOException {
                //Client c = clientService.createClient(client);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Client client1 = objectMapper.readValue(client, Client.class);

        try {
            Client c = clientService.createClient(client1);
            System.out.println("//////**********//////////µ*********************************************************************************");
            System.out.println(client1);
            System.out.println(c);
            System.out.println(files.length);
            for (MultipartFile file: files) {
                System.out.println("file.getBytes()");

            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("get-client-id")
    public Client findOneByCientId(@RequestParam(name = "clientID",  required = true) Long clientID) {
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
