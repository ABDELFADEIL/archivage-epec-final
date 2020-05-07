package org.simplon.epec.archivage.infrastructure.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.account.repository.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {


    private final transient AccountJpaRepository accountJpaRepository;


    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Account createAccount(String clientID) {
        return accountJpaRepository.save(new Account( "null",  "account_id_type_code",  "account_id_label",  null));
    }
}
