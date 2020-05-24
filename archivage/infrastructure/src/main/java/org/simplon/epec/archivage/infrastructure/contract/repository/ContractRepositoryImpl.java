package org.simplon.epec.archivage.infrastructure.contract.repository;

import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.contract.repository.ContractRepository;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private final transient ContractJpaRepository contractJpaRepository;
    private final transient EventRepository eventRepository;
    private final transient ClassificationNatureRepository classificationNatureRepository;

    public ContractRepositoryImpl(ContractJpaRepository contractJpaRepository, EventRepository eventRepository, ClassificationNatureRepository classificationNatureRepository) {
        this.contractJpaRepository = contractJpaRepository;
        this.eventRepository = eventRepository;
        this.classificationNatureRepository = classificationNatureRepository;
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractJpaRepository.save(contract);
    }

    @Override
    public Contract getContractByCientId(Long clientID) {
        return contractJpaRepository.findByClient(clientID);
    }

    @Override
    public Contract getContractByNumber(String contract_number) {
        return contractJpaRepository.findByContract_number(contract_number);
    }

    @Override
    public Contract UpdateContract(Contract contract) {
        return contractJpaRepository.save(contract);
    }

    @Override
    public void removeContract(Contract contract) {
        contractJpaRepository.delete(contract);

    }

    @Override
    public Set<Contract> getContractsByContractNumberContains(String contractNumber) {
        return contractJpaRepository.findByContract_numberContains(contractNumber);
    }

    @Override
    public Set<Contract> getContractsByClientNameContains(String name) {
        return contractJpaRepository.getContractsByClientNameContains(name);
    }

    @Override
    public String getMaxContractNumber() {
        return contractJpaRepository.findMaxContractNumber();
    }

    @Override
    public Set<Contract> findContractByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor) {
        return contractJpaRepository.findContractsByEventStatusAndEventDateAfterAndDateBefor(status, dateAfter, dateBefor);
    }

    @Override
    public Contract createEvent(Contract contract, Event event) {
         eventRepository.createEventContract(contract, event);
         return contractJpaRepository.findByContract_number(contract.getContract_number());
    }
}
