package org.simplon.epec.archivage.domain.account.repository;

import org.simplon.epec.archivage.domain.account.entity.Account;

public interface AccountRepository {

    public Account createAccount(String clientID);
}
