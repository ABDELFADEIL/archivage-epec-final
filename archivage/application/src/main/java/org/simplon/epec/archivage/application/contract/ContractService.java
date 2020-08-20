package org.simplon.epec.archivage.application.contract;

import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Set;

public interface ContractService {

     Contract createContract(Contract contract);
     Contract getContractByCientId(String clientID);
     Contract getContractByNumber(String contract_number);
     Contract UpdateAccount(Contract contract);
     void removeContract(Contract contract);
     Set<Contract> getContractsByContractNumberContains(String contract_number);
     Set<Contract> getContractsByClientNameContains(String client_name);
     String getMaxContractNumber();
     Set<Contract> findContractByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor);
     String createNewContractNumber();
     Contract findById(String id);
    Set<Contract> getContractsByClientNameAndContractNumberContains(String client_name, String contract_number);
}
