package org.simplon.epec.archivage.exposition.contract.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.application.client.ClientService;
import org.simplon.epec.archivage.application.contract.ContractService;
import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/api/contracts")
public class ContractResource {

    private final transient ContractService contractService;
    private final transient DigitalDocumentService documentService;
    private final transient ClientService clientService;

    public ContractResource(ContractService contractService, DigitalDocumentService documentService, ClientService clientService) {
        this.contractService = contractService;
        this.documentService = documentService;
        this.clientService = clientService;
    }


    @GetMapping("/get-contractts-status")
    public Set<Contract> getContractByEventAndDateAfterAndDateBefor(
            @RequestParam(name = "status", required = true) String status,
            @RequestParam("dateAfter") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateAfter,
            @RequestParam("dateBefor") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBefor
    )
    {
        return contractService.findContractByEventStatusEventDateBeforAndDateAfter(status, dateAfter, dateBefor);
    }

    @PostMapping(value = "/new-contract-with-docs", consumes = {"multipart/form-data;boundary=----WebKitFormBoundaryGU19yc6e19LFwvk2"})
    public List<DigitalDocument> createContract(
                                    @RequestPart("contract") String contract,
                                    @RequestPart("client") String client,
                                    @RequestPart("classificationNature") String classificationNature,
                                    @RequestPart("final_business_processing_date") String final_business_processing_date,
                                    @RequestPart("files") MultipartFile[] files
                                   ) throws IOException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException {

        List<DigitalDocument> documentList = new ArrayList<DigitalDocument>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Contract contract1 = objectMapper.readValue(contract, Contract.class);
        //Client c = contract1.getClient();
        // Client c = contract1.getClient();
        Client c = objectMapper.readValue(client, Client.class);
        ClassificationNature classificationNature1 = objectMapper.readValue(classificationNature, ClassificationNature.class);
        String dateString = objectMapper.readValue(final_business_processing_date, String.class);

        LocalDateTime FBPD=null;
        LocalDate finalBusiness_ProcessingDate = null;
        if(!dateString.isEmpty() || dateString.equals(null)){
            //FBPD =  LocalDateTime.parse(dateString);
            finalBusiness_ProcessingDate = LocalDate.parse(dateString).plusDays(1l);
        }
        Contract contract2 = contractService.createContract(new Contract(contract1.getContract_id_type_code(), contract1.getContract_id_type_label(), c));
        DigitalDocument document = null;

        if (files.length > 0) {
            for (MultipartFile file: files) {
                Context ctx = new Context(RandomUtils.nextLong(), null, classificationNature1, finalBusiness_ProcessingDate, null, c);
                ctx.setContract(contract2);
                ctx.setMine_type(file.getContentType());
                document = new DigitalDocument(file.getOriginalFilename(), file.getContentType().split("/")[1], null, ctx);
                DigitalDocument doc = documentService.createDocument(document, classificationNature1, file);
               // documentService.savedoc(doc);
                documentList.add(doc);
            }
        }
        return documentList;
    }

    @PutMapping("/update-contract")
    public Contract updateContract(@RequestBody  Contract contract) {
        return contractService.UpdateAccount(contract);
    }

    // update-contract-docs
    @PutMapping(value = "/update-contract-docs", consumes = {"multipart/form-data;boundary=----WebKitFormBoundaryGU19yc6e19LFwvk2"})
    public Contract updateDocsContract(@RequestPart("contract_id")  String contract_id, @RequestPart("files")  MultipartFile [] files) throws BadPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        return documentService.addDocsToContract(contract_id, files);
    }


    @GetMapping("/get-contract-by-client-id")
    public Contract getAccountByCientId(@RequestParam("clientID") String clientID) {
        return contractService.getContractByCientId(clientID);
    }

    @GetMapping("/get-contract-by-number")
    public Contract getByContractNumber(@RequestParam("account_number") String contract_number){
        return contractService.getContractByNumber(contract_number);
    }

    @DeleteMapping("/remove-contract")
    public void removeContract(@RequestBody Contract contract){
        contractService.removeContract(contract);
    }

    @GetMapping("/get-contracts-by-number-key")
    public Set<Contract> getContractsByContractNumberContains( @RequestParam("contract_number") String contract_number) {
        return contractService.getContractsByContractNumberContains(contract_number);
    }

    @GetMapping("/get-contracts-by-client-name-key")
    public Set<Contract> getContractsByClientNameContains(@RequestParam("name") String name) {
        return contractService.getContractsByClientNameContains(name);
    }


    @GetMapping("/get-contracts-by-client-name-number")
    public Set<Contract> getContractsByClientNameAndCOntractNumberContains(
            @RequestParam(value = "contract_number") String contract_number,
            @RequestParam(value = "client_name") String client_name) {
        return contractService.getContractsByClientNameAndContractNumberContains(client_name, contract_number);
    }


}
