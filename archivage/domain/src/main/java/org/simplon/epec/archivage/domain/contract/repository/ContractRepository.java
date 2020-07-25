package org.simplon.epec.archivage.domain.contract.repository;

import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.event.entity.Event;

import java.time.LocalDate;
import java.util.Set;

public interface ContractRepository {

    Contract createContract(Contract contract);
    Contract getContractByCientId(String clientID);
    Contract getContractByNumber(String contract_number);
    Contract UpdateContract(Contract contract);
    void removeContract(Contract contract);
    Set<Contract> getContractsByContractNumberContains(String clientNumber);
    Set<Contract> getContractsByClientNameContains(String name);
    String getMaxContractNumber();
    Set<Contract> findContractByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor);
    Contract createEvent(Contract contract, Event event);
    Contract findById(String id);
}
