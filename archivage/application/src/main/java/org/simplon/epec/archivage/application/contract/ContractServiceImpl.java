package org.simplon.epec.archivage.application.contract;

import org.simplon.epec.archivage.domain.account.entity.Account;
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

    public ContractServiceImpl(ContractRepository contractRepository1, UserRepository userRepository) {
        this.contractRepository = contractRepository1;
        this.userRepository = userRepository;
    }


    @Override
    public Contract createAccount(Contract contract) {
        String contract_number = createNewContractNumber();
        User user = userRepository.getAuthentificatedUser();
        Contract c = new Contract( contract.getContract_id_type_code(),  contract.getContract_id_type_label(),
                contract.getClient(), contract_number);
        return contractRepository.createContract(c);
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
        String contract_number_pre = contractRepository.getMaxContractNumber();
        long contract_number =  Long.parseLong(contract_number_pre);
        long new_contract_number = contract_number + 1;
        String contact_number_nex = "00000000000".substring(String.valueOf(new_contract_number).length()+1)+new_contract_number;
        return contact_number_nex;
    }
}
