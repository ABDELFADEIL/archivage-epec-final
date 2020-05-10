package org.simplon.epec.archivage.application.account;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final transient AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Set<Account> findAccountByStatusAndEventDateAfterAndEvenDateBefor(String status, Date dateAfter, Date dateBefor) {
        return accountRepository.findAccountByStatusAndEventDateAfterAndEvenDateBefor(status, dateAfter, dateBefor);
    }
}
