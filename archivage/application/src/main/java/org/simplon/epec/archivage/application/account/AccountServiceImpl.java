package org.simplon.epec.archivage.application.account;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.account.repository.AccountRepository;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final transient AccountRepository accountRepository;
    private final transient UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Account createAccount(Account account) {
        String account_number = createNewAccountNumber();
        User user = userRepository.getAuthentificatedUser();
        Account a = new Account( account.getAccount_id_type_code(),  account.getAccount_id_label(),  account_number,
                account.getClient(), user);
        return accountRepository.createAccount(a);
    }

    @Override
    public Account getAccountByCientId(String clientID) {
        return accountRepository.getAccountByCientId(clientID);
    }

    @Override
    public Account getAccountByNumber(String account_number) {
        return accountRepository.getAccountByNumber(account_number);
    }

    @Override
    public Account UpdateAccount(Account account) {
        return accountRepository.UpdateAccount(account);
    }

    @Override
    public void removeAccount(Account account) {
      accountRepository.removeAccount(account);
    }

    @Override
    public Set<Account> getAccountsByAccountNumberContains(String clientNumber) {
        return accountRepository.getAccountsByAccountNumberContains(clientNumber);
    }

    @Override
    public Set<Account> getAccountsByClientNameContains(String name) {
        return accountRepository.getAccountsByClientNameContains(name);
    }

    @Override
    public String getMaxAccountNumber() {
        return accountRepository.getMaxAccountNumber();
    }

    @Override
    public Set<Account> findAccountByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor) {
        return accountRepository.findAccountByEventStatusEventDateBeforAndDateAfter(status, dateAfter, dateBefor);
    }

    @Override
    public String createNewAccountNumber() {
        String account_number_pre = accountRepository.getMaxAccountNumber();
        long account_number =  Long.parseLong(account_number_pre);
        long new_account_number = account_number + 1;
        String account_number_nex = "00000000000".substring(String.valueOf(new_account_number).length()+1)+new_account_number;
        return account_number_nex;
    }
}
