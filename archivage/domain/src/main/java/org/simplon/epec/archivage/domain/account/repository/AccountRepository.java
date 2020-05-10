package org.simplon.epec.archivage.domain.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.client.entity.Client;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public interface AccountRepository {

     Account createAccount(Account account);
    Account getAccountByCientId(String clientID);
    Account getAccountByNumber(String account_number);
    Account UpdateAccount(Account account);
    void removeAccount(Account account);
    Set<Account> getAccountsByNumberAccountContains(String clientNumber);
    Set<Client> getAccountsByClientNameContains(String name);
    String getMaxAccountNumber();
    Set<Account> findAccountByStatusAndEventDateAfterAndEvenDateBefor(String status, Date dateAfter, Date dateBefor);

}
