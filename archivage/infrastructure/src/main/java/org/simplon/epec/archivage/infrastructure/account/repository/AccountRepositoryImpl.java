package org.simplon.epec.archivage.infrastructure.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.account.repository.AccountRepository;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

@Repository
public class AccountRepositoryImpl implements AccountRepository {


    private final transient AccountJpaRepository accountJpaRepository;


    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }


    @Override
    public Account createAccount(Account account) {
        return accountJpaRepository.save(account);
    }

    @Override
    public Account getAccountByCientId(String clientID) {
        return accountJpaRepository.getOne(clientID);
    }

    @Override
    public Account getAccountByNumber(String account_number) {
        return accountJpaRepository.findByAccountNumber(account_number);
    }

    @Override
    public Account UpdateAccount(Account account) {
        return accountJpaRepository.save(account);
    }

    @Override
    public void removeAccount(Account account) {
      accountJpaRepository.delete(account);
    }

    @Override
    public Set<Account> getAccountsByNumberAccountContains(String account_number) {
        return accountJpaRepository.getAccountsByNumberAccountContains(account_number);
    }

    @Override
    public Set<Client> getAccountsByClientNameContains(String name) {
        return accountJpaRepository.getAccountsByClientNameContains(name);
    }

    @Override
    public String getMaxAccountNumber() {
        return accountJpaRepository.findMaxClientNumber();
    }

    @Override
    public Set<Account> findAccountByStatusAndEventDateAfterAndEvenDateBefor(String status, Date dateAfter, Date dateBefor) {
        // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime
        return accountJpaRepository.findAccountByStatusAndEvent_Event_date(status, dateAfter, dateBefor);
    }



}
