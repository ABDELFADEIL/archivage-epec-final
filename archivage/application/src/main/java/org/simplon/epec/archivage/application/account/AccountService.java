package org.simplon.epec.archivage.application.account;

import org.simplon.epec.archivage.domain.account.entity.Account;

import java.time.LocalDate;
import java.util.Set;

public interface AccountService {

    public Account createAccount(Account account);
    public Account getAccountByCientId(String clientID);
    public Account getAccountByNumber(String account_number);
    public Account UpdateAccount(Account account);
    public void removeAccount(Account account);
    public Set<Account> getAccountsByAccountNumberContains(String clientNumber);
    public Set<Account> getAccountsByClientNameContains(String name);
    public String getMaxAccountNumber();
    public Set<Account> findAccountByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor);
    public String createNewAccountNumber();
    Set<Account> getAccountstsByClientNameAndAccountNumberContains(String client_name, String account_number);
}
