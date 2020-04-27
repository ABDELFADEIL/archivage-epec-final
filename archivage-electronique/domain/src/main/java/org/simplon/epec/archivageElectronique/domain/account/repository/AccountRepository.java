package org.simplon.epec.archivageElectronique.domain.account.repository;

import org.simplon.epec.archivageElectronique.domain.account.entity.Account;

public interface AccountRepository {

    public Account createAccount(String clientID);
}
