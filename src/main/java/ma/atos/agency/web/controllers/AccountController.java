package ma.atos.agency.web.controllers;

import ma.atos.agency.entities.Account;
import ma.atos.agency.services.imp.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    private AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @GetMapping(path = "/account/{accountNumber}")
    private Account getAccount(@PathVariable("accountNumber") String accountNumber) {
        return accountService.getAccount(accountNumber);
    }
}
