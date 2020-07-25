package org.simplon.epec.archivage.exposition.contract.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.application.contract.ContractService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/contracts")
public class ContractResource {

    private final ContractService contractService;

    public ContractResource(ContractService contractService) {
        this.contractService = contractService;
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

    @PostMapping("/new-contract-with-docs")
    public Contract createContract(
                                    @RequestPart("contract") Contract contract,
                                    @RequestPart("classificationNature") String classificationNature,
                                    @RequestPart("final_business_processing_date") String final_business_processing_date,
                                    @RequestPart("files") MultipartFile[] files

                                   ) {

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

        return contractService.createContract(contract);
                                      }

    @PostMapping("/update-contract")
    public Contract updateContract(@RequestBody  Contract contract) {
        return contractService.UpdateAccount(contract);
    }


    @GetMapping("/get-contract-by-client-id")
    public Contract getAccountByCientId(@RequestParam("clientID") Long clientID) {
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


}
