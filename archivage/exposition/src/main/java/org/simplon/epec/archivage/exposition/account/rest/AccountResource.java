package org.simplon.epec.archivage.exposition.account.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.application.account.AccountService;
import org.simplon.epec.archivage.application.client.ClientService;
import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountService accountService;
    private final transient DigitalDocumentService documentService;
    private final transient ClientService clientService;
    public AccountResource(AccountService accountService, DigitalDocumentService documentService, ClientService clientService) {
        this.accountService = accountService;
        this.documentService = documentService;
        this.clientService = clientService;
    }


    @GetMapping("/get-accounts-status")
    public Set<Account> getClientsByNameContains(
                                                 @RequestParam(name = "status", required = true) String status,
                                                 @RequestParam("dateAfter") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateAfter,
                                                 @RequestParam("dateBefor") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBefor
                                                )
    {
        return accountService.findAccountByEventStatusEventDateBeforAndDateAfter(status, dateAfter, dateBefor);
    }

    @PostMapping(value = "/create-new-account-with-docs", consumes = {"multipart/form-data;boundary=----WebKitFormBoundaryGU19yc6e19LFwvk2"})
    public List<DigitalDocument> createAccount(
            @RequestPart("account") String account,
            @RequestPart("client") String client,
            @RequestPart("classificationNature") String classificationNature,
          //  @RequestPart("final_business_processing_date") String final_business_processing_date,
            @RequestPart("files") MultipartFile[] files
    ) throws IOException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException {

        List<DigitalDocument> documentList = new ArrayList<DigitalDocument>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Account account1 = objectMapper.readValue(account, Account.class);
        //Client c = contract1.getClient();
        // Client c = contract1.getClient();
        Client c = objectMapper.readValue(client, Client.class);
        ClassificationNature classificationNature1 = objectMapper.readValue(classificationNature, ClassificationNature.class);

       /*
       LocalDate finalBusiness_ProcessingDate = null;
       if (!final_business_processing_date.equals(null) || final_business_processing_date.isEmpty()){
            String dateString = objectMapper.readValue(final_business_processing_date, String.class);
            LocalDateTime FBPD=null;
            if(!dateString.isEmpty() || dateString != null){
                //FBPD =  LocalDateTime.parse(dateString);
                finalBusiness_ProcessingDate = LocalDate.parse(dateString).plusDays(1l);
            }
        }

        */
        Account account2 = accountService.createAccount(new Account(account1.getAccount_id_type_code(), account1.getAccount_id_type_label(), c, account1.getUser_id()));
        DigitalDocument document = null;

        if (files.length > 0) {
            for (MultipartFile file: files) {
                Context ctx = new Context(RandomUtils.nextLong()+"", null, classificationNature1, c);
                ctx.setAccount(account2);
                ctx.setMine_type(file.getContentType());
                document = new DigitalDocument(file.getOriginalFilename(), file.getContentType().split("/")[1], null, ctx);
                DigitalDocument doc = documentService.createDocument(document, classificationNature1, file);
                // documentService.savedoc(doc);
                documentList.add(doc);
            }
        }
        return documentList;
    }

    @PutMapping(value = "/update-account-docs", consumes = {"multipart/form-data;boundary=----WebKitFormBoundaryGU19yc6e19LFwvk2"})
    public Account updateDocsAccount(@RequestPart("account_id")  String account_id, @RequestPart("files")  MultipartFile [] files) throws BadPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        return documentService.addDocsToAccount(account_id, files);
    }


    @PutMapping(value = "/update-account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account updateAccount(@RequestBody Account account) {
        return accountService.UpdateAccount(account);
    }


    @GetMapping("/get-account-by-client-id")
    public Account getAccountByCientId(@RequestParam("clientID") String clientID) {
     return accountService.getAccountByCientId(clientID);
    }

    @GetMapping("/get-account-by-number")
    public Account getAccountByNumber(@RequestParam("account_number") String account_number){
        return accountService.getAccountByNumber(account_number);
    }

    @DeleteMapping("/remove-account")
    public void removeAccount(@RequestBody Account account){
        accountService.removeAccount(account);
    }

    @GetMapping("/get-accounts-by-number-key")
    public Set<Account> getAccountsByAccountNumberContains(String account_number) {
       return accountService.getAccountsByAccountNumberContains(account_number);
    }

    @GetMapping("/get-accounts-by-client-name-key")
    public Set<Account> getAccountsByClientNameContains(String name) {
        return accountService.getAccountsByClientNameContains(name);
    }


    @GetMapping("/get-accounts-by-client-name-account-number")
    public Set<Account> getAccountsByClientNameAndAccountNumberContains(
            @RequestParam(value = "account_number") String account_number,
            @RequestParam(value = "client_name") String client_name) {
        return accountService.getAccountstsByClientNameAndAccountNumberContains(client_name, account_number);
    }

}
