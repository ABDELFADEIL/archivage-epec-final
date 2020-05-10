package org.simplon.epec.archivage.infrastructure.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public interface AccountJpaRepository extends JpaRepository<Account, String> {

    @Query(value="select MAX(a.account_number) from account a group by a.account_number order by a.account_number desc limit 1", nativeQuery=true)
    public String findMaxClientNumber();

    @Query("select account from Account account where account.account_number=:account_number")
    Account findByAccountNumber(@Param("account_number") String account_number);

    @Query("select account from Account account where account.account_number like %:account_number%")
    Set<Account> getAccountsByNumberAccountContains(@Param("account_number") String account_number);

    @Query("select account from Account account where account.client.client_name like %:client_name% or account.client.client_first_name like %:client_name%")
    Set<Client> getAccountsByClientNameContains(@Param("client_name") String client_name);

    //findAccountByStatusAndEventDateAfterAndEvenDateBefor
    @Query(value="select * from  account where account.status=status and account.event in (select id_event from  event where event_type=:status and event_date between :dateAfter and :dateBefor)", nativeQuery=true)
    Set<Account> findAccountByStatusAndEvent_Event_date(@Param("status") String status, @Param("dateAfter") Date dateAfter, @Param("dateBefor") Date dateBefor);
}
