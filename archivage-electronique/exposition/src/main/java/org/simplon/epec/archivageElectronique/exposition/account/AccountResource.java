package org.simplon.epec.archivageElectronique.exposition.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.simplon.epec.archivageElectronique.domain.account.entity.Account;

@RestController
@RequestMapping("/api")
public class AccountResource {

    @GetMapping("/account")
    public Account getAccount(){
        Account account = new Account();
        account.setAccount_id("abcd");
        account.setAccount_id_label("slflfl");
        account.setAccount_number("FR1234000000");
        return account;
    }
}
