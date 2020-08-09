package org.simplon.epec.archivage.infrastructure.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.account.repository.AccountRepository;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.event.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public class AccountRepositoryImpl implements AccountRepository {


    private final transient AccountJpaRepository accountJpaRepository;
    private final transient EventRepository eventRepository;
    private final transient ClassificationNatureRepository classificationNatureRepository;


    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository, EventRepository eventRepository, ClassificationNatureRepository classificationNatureRepository) {
        this.accountJpaRepository = accountJpaRepository;
        this.eventRepository = eventRepository;
        this.classificationNatureRepository = classificationNatureRepository;
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
        return accountJpaRepository.findByAccount_number(account_number);
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
    public Set<Account> getAccountsByAccountNumberContains(String account_number) {
        return accountJpaRepository.findByAccount_numberContains(account_number);
    }

    @Override
    public Set<Account> getAccountsByClientNameContains(String name) {
        return accountJpaRepository.getAccountsByClientNameContains(name);
    }

    @Override
    public String getMaxAccountNumber() {
        return accountJpaRepository.findMaxAccountNumber();
    }

    @Override
    public Set<Account> findAccountByEventStatusEventDateBeforAndDateAfter(String status, LocalDate dateAfter, LocalDate dateBefor) {
        // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime
        return accountJpaRepository.findAccountByEventStatusEventDateBeforAndDateAfter(status, dateAfter, dateBefor);
    }

    @Override
    public Account createEvent(Account account, Event event) {
          eventRepository.createEventAccount(account, event);
          return accountJpaRepository.findByAccount_number(account.getAccount_number());

    }


}
