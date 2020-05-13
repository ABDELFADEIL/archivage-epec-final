package org.simplon.epec.archivage.infrastructure.contract.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public interface ContractJpaRepository extends JpaRepository<Contract, String> {

    @Query(value="select MAX(a.account_number) from account a group by a.account_number order by a.account_number desc limit 1", nativeQuery=true)
    public String findMaxAccountNumber();

    @Query("select contract from Contract contract where contract.contract_number=:contract_number")
    Contract findByContract_number(@Param("contract_number") String contract_number);

    @Query("select contract from Contract contract where contract.contract_number like %:contract_number%")
    Set<Contract> findByContract_numberContains(@Param("contract_number") String contract_number);

    @Query("select contract from Contract contract where contract.client.client_name like %:client_name% or contract.client.client_first_name like %:client_name%")
    Set<Contract> getContractsByClientNameContains(@Param("client_name") String client_name);

    //findAccountByStatusAndEventDateAfterAndEvenDateBefor
    @Query(value="select * from  contract where contract.event in (select id_event from  event where event_type=:status and event_date between :dateAfter and :dateBefor)", nativeQuery=true)
    Set<Contract> findContractsByEventStatusAndEventDateAfterAndDateBefor(@Param("status") String status, @Param("dateAfter") LocalDate dateAfter, @Param("dateBefor") LocalDate dateBefor);

    public Contract findByClient(@Param("client_id")String client_id);


}
