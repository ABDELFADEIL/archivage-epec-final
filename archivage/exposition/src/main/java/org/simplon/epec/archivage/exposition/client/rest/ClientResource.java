package org.simplon.epec.archivage.exposition.client.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.application.client.ClientService;
import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/clients")
public class ClientResource {

    private final transient ClientService clientService;
    private final transient DigitalDocumentService documentService;

    public ClientResource(ClientService clientService, DigitalDocumentService documentService) {
        this.clientService = clientService;
        this.documentService = documentService;
    }

    @PostMapping("create-new-client")
    public Client createClient(@RequestBody(required = true) Client client) {
        return clientService.createClient(client);
    }


   @PostMapping(value = "/new-client-with-docs", consumes = {"multipart/form-data;boundary=----WebKitFormBoundaryGU19yc6e19LFwvk2"})
    public List<DigitalDocument> createClientWithdocs(
            @RequestPart("client") String client,
             @RequestPart("classificationNature") String classificationNature,
            @RequestPart("final_business_processing_date") String final_business_processing_date,
             @RequestPart("files") MultipartFile  [] files) throws IOException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException {
        List<DigitalDocument> documentList = new ArrayList<DigitalDocument>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Client client1 = objectMapper.readValue(client, Client.class);
        ClassificationNature classificationNature1 = objectMapper.readValue(classificationNature, ClassificationNature.class);
        String dateString = objectMapper.readValue(final_business_processing_date, String.class);
        LocalDateTime FBPD=null;
        LocalDate finalBusiness_ProcessingDate = null;
        if(!dateString.isEmpty() || dateString.equals(null)){
             //FBPD =  LocalDateTime.parse(dateString);
            finalBusiness_ProcessingDate = LocalDate.parse(dateString).plusDays(1l);
        }

            Client c = clientService.createClient(client1);
            DigitalDocument document = null;
            Context ctx = new Context(RandomUtils.nextLong(), null, classificationNature1, finalBusiness_ProcessingDate, null, c);

            if (files.length > 0) {
                for (MultipartFile file: files) {
                    ctx.setMine_type(file.getContentType());
                    document = new DigitalDocument(file.getOriginalFilename(), file.getContentType().split("/")[1], null, ctx);
                    DigitalDocument doc = documentService.createDocument(document, classificationNature1, file);
                    documentList.add(doc);
                }
            }

            return documentList;
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
