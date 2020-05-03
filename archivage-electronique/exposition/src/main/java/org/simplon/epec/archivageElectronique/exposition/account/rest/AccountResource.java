package org.simplon.epec.archivageElectronique.exposition.account.rest;

import org.simplon.epec.archivageElectronique.domain.account.entity.Account;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@Validated
public class AccountResource {

    @GetMapping("/account")
    public Set<Account> getAccount(){
        Account account = new Account();
        account.setAccount_id("cfd");
        account.setAccount_id_label("slflfl");
        account.setAccount_number("FR1234000000");
        Account account1 = new Account();
        account1.setAccount_id("abcd");
        account1.setAccount_id_label("mhjk");
        account1.setAccount_number("FR123400023");
        Set<Account> accounts = new LinkedHashSet<>();
        accounts.add(account);
        accounts.add(account1);
        return accounts;
    }


}
