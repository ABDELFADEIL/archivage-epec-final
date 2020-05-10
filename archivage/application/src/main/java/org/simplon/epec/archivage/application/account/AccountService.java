package org.simplon.epec.archivage.application.account;

import org.simplon.epec.archivage.domain.account.entity.Account;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public interface AccountService {

    public Set<Account> findAccountByStatusAndEventDateAfterAndEvenDateBefor(String status, Date dateAfter, Date dateBefor);
}
