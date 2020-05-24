package org.simplon.epec.archivage.application.contract;

import org.simplon.epec.archivage.domain.contract.entity.Contract;

import java.time.LocalDate;
import java.util.Set;

public interface ContractService {

    public Contract createContract(Contract contract);
    public Contract getContractByCientId(Long clientID);
    public Contract getContractByNumber(String contract_number);
    public Contract UpdateAccount(Contract contract);
    public void removeContract(Contract contract);
    public Set<Contract> getContractsByContractNumberContains(String contract_number);
    public Set<Contract> getContractsByClientNameContains(String client_name);
    public String getMaxContractNumber();
    public Set<Contract> findContractByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor);
    public String createNewContractNumber();

}
