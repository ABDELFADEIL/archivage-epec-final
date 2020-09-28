package org.simplon.epec.archivage.domain.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;

import java.time.LocalDate;
import java.util.Set;

public interface AccountRepository {

    Account createAccount(Account account);
    Account getAccountByCientId(String clientID);
    Account getAccountByNumber(String account_number);
    Account UpdateAccount(Account account);
    void removeAccount(Account account);
    Set<Account> getAccountsByAccountNumberContains(String clientNumber);
    Set<Account> getAccountsByClientNameContains(String name);
    String getMaxAccountNumber();
    Set<Account> findAccountByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor);
    Account createEvent(Account account);
    Set<Account> getAccountstsByClientNameAndAccountNumberContains(String client_name, String account_number);
    Account findById(String account_id);
    Account save(Account a);
}
