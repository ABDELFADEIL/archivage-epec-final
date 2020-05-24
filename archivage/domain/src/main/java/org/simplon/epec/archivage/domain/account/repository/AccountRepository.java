package org.simplon.epec.archivage.domain.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.event.entity.Event;

import java.time.LocalDate;
import java.util.Set;

public interface AccountRepository {

    Account createAccount(Account account);
    Account getAccountByCientId(Long clientID);
    Account getAccountByNumber(String account_number);
    Account UpdateAccount(Account account);
    void removeAccount(Account account);
    Set<Account> getAccountsByAccountNumberContains(String clientNumber);
    Set<Account> getAccountsByClientNameContains(String name);
    String getMaxAccountNumber();
    Set<Account> findAccountByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor);
    Account createEvent(Account account ,Event event);







}
