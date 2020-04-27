package org.simplon.epec.archivageElectronique.infrastructure.account.repository;

import org.simplon.epec.archivageElectronique.domain.account.entity.Account;
import org.simplon.epec.archivageElectronique.domain.account.repository.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final transient AccountJpaRepository accountJpaRepository;

    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Account createAccount(String clientID) {
        return null;
    }
}
