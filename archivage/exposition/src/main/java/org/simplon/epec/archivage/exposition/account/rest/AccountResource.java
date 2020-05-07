package org.simplon.epec.archivage.exposition.account.rest;

import org.simplon.epec.archivage.domain.account.entity.Account;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class AccountResource {

    @RequestMapping(path = {"/", "/unsecured"})
    public String noSecuredEndpoint(){
        return "This is an unsecured endpoint payload";
    }
    @RequestMapping(
            path = "/admin",
            method = RequestMethod.GET, // @RequestMapping default assignment
            produces = MediaType.APPLICATION_JSON_VALUE // TIP : use org.springframework.http.MediaType for MimeType instead of hard coded value
    )
    public String adminSecuredEndpoint(){
        return "This is an ADMIN endpoint payload";
    }
    @RequestMapping("/user")
    public String userSecuredEndpoint(){
        return "This is an USER endpoint payload";
    }

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

    @GetMapping("/contract")
    public Set<Account> getTest(){
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
