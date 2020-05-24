package org.simplon.epec.archivage.exposition.account.rest;

import org.simplon.epec.archivage.application.account.AccountService;
import org.simplon.epec.archivage.domain.account.entity.Account;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/get-accounts-status")
    public Set<Account> getClientsByNameContains(
                                                 @RequestParam(name = "status", required = true) String status,
                                                 @RequestParam("dateAfter") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateAfter,
                                                 @RequestParam("dateBefor") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBefor
                                                )
    {
        return accountService.findAccountByEventStatusEventDateBeforAndDateAfter(status, dateAfter, dateBefor);
    }

    @PostMapping("/create-new-account")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/update-account")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.UpdateAccount(account);
    }


    @GetMapping("/get-account-by-client-id")
    public Account getAccountByCientId(@RequestParam("clientID") Long clientID) {
     return accountService.getAccountByCientId(clientID);
    }

    @GetMapping("/get-account-by-number")
    public Account getAccountByNumber(@RequestParam("account_number") String account_number){
        return accountService.getAccountByNumber(account_number);
    }

    @DeleteMapping("/remove-account")
    public void removeAccount(@RequestBody Account account){
        accountService.removeAccount(account);
    }

    @GetMapping("/get-accounts-by-number-key")
    public Set<Account> getAccountsByAccountNumberContains(String account_number) {
       return accountService.getAccountsByAccountNumberContains(account_number);
    }

    @GetMapping("/get-accounts-by-client-name-key")
    public Set<Account> getAccountsByClientNameContains(String name) {
        return accountService.getAccountsByClientNameContains(name);
    }


}
