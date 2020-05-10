package org.simplon.epec.archivage.exposition.account.rest;

import org.simplon.epec.archivage.application.account.AccountService;
import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

    @Autowired
    private AccountService accountService;


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

    @GetMapping("/get-accounts-status")
    public Set<Account> getClientsByNameContains(
                                                 @RequestParam(name = "status", required = true) String status,
                                                 @RequestParam("dateAfter") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateAfter,
                                                 @RequestParam("dateBefor") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateBefor
                                                )
    {
        return accountService.findAccountByStatusAndEventDateAfterAndEvenDateBefor(status, dateAfter, dateBefor);
    }


}
