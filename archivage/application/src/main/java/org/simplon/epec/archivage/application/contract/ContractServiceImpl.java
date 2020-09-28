package org.simplon.epec.archivage.application.contract;

import org.simplon.epec.archivage.application.event.EventService;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.contract.repository.ContractRepository;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private final transient ContractRepository contractRepository;
    private final transient UserRepository userRepository;
    private final transient EventService eventService;

    public ContractServiceImpl(ContractRepository contractRepository1, UserRepository userRepository, EventService eventService) {
        this.contractRepository = contractRepository1;
        this.userRepository = userRepository;
        this.eventService = eventService;
    }


    @Override
    public Contract createContract(Contract contract) {
        Contract c = null;
        try {
            String contract_number = createNewContractNumber();
            User user = userRepository.getAuthenticatedUser();
            contract.setContract_number(contract_number);
            contract.setUser_id(user.getUser_id());
             c = contractRepository.createContract(contract);
            eventService.createEventContract(c);
        }catch (Exception e){
            e.getStackTrace();
        }
        return c;
    }

    @Override
    public Contract getContractByCientId(String clientID) {
        return contractRepository.getContractByCientId(clientID);
    }

    @Override
    public Contract getContractByNumber(String contract_number) {
        return contractRepository.getContractByNumber(contract_number);
    }

    @Override
    public Contract UpdateAccount(Contract contract) {
        return contractRepository.UpdateContract(contract);
    }

    @Override
    public void removeContract(Contract contract) {
      contractRepository.removeContract(contract);
    }

    @Override
    public Set<Contract> getContractsByContractNumberContains(String contract_number) {
        return contractRepository.getContractsByContractNumberContains(contract_number);
    }

    @Override
    public Set<Contract> getContractsByClientNameContains(String client_name) {
        return contractRepository.getContractsByClientNameContains(client_name);
    }

    @Override
    public String getMaxContractNumber() {
        return contractRepository.getMaxContractNumber();
    }

    @Override
    public Set<Contract> findContractByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor) {
        return contractRepository.findContractByEventStatusEventDateBeforAndDateAfter(status, dateAfter, dateBefor);
    }

    @Override
    public String createNewContractNumber() {
        System.out.println("contract_number_pre///////////////////////////////*******************************************************************************");
        String contract_number_pre = getMaxContractNumber();
        System.out.println(contract_number_pre);
        long contract_number =  Long.parseLong(contract_number_pre);
        System.out.println(contract_number);
        long new_contract_number = contract_number + 1;
        System.out.println(new_contract_number);
        String contract_number_nex = "00000000000".substring(String.valueOf(new_contract_number).length()+1)+new_contract_number;
        System.out.println(contract_number_nex);
        return contract_number_nex;
    }

    @Override
    public Contract findById(String id) {
        return contractRepository.findById(id);
    }

    @Override
    public Set<Contract> getContractsByClientNameAndContractNumberContains(String client_name, String contract_number) {
        return contractRepository.getContractsByClientNameAndContractNumberContains(client_name, contract_number);
    }


}
