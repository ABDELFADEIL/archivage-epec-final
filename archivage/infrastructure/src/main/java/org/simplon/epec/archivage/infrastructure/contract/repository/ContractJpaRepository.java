package org.simplon.epec.archivage.infrastructure.contract.repository;

import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Set;

public interface ContractJpaRepository extends JpaRepository<Contract, Long> {

    @Query(value="select MAX(c.contract_number) from contract c group by c.contract_number order by c.contract_number desc limit 1", nativeQuery=true)
    public String findMaxContractNumber();

    @Query("select contract from Contract contract where contract.contract_number=:contract_number")
    Contract findByContract_number(@Param("contract_number") String contract_number);

    @Query("select contract from Contract contract where contract.contract_number like %:contract_number%")
    Set<Contract> findByContract_numberContains(@Param("contract_number") String contract_number);

    @Query("select contract from Contract contract where contract.client.client_name like %:client_name% or contract.client.client_first_name like %:client_name%")
    Set<Contract> getContractsByClientNameContains(@Param("client_name") String client_name);

    //findAccountByStatusAndEventDateAfterAndEvenDateBefor
    @Query(value="select * from  contract where contract.event in (select id_event from  event where event_type=:status and event_date between :dateAfter and :dateBefor)", nativeQuery=true)
    Set<Contract> findContractsByEventStatusAndEventDateAfterAndDateBefor(@Param("status") String status, @Param("dateAfter") LocalDate dateAfter, @Param("dateBefor") LocalDate dateBefor);

    public Contract findByClient(@Param("client_id")Long client_id);


}
