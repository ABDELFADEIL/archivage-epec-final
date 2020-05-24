package org.simplon.epec.archivage.exposition.contract.rest;

import org.simplon.epec.archivage.application.contract.ContractService;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping("/create-new-account")
    public Contract createAccount(@RequestBody Contract contract) {
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
    public Set<Contract> getContractsByContractNumberContains(String contract_number) {
        return contractService.getContractsByContractNumberContains(contract_number);
    }

    @GetMapping("/get-contracts-by-client-name-key")
    public Set<Contract> getContractsByClientNameContains(String name) {
        return contractService.getContractsByClientNameContains(name);
    }


}
