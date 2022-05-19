package ma.atos.agency.services.imp;

import ma.atos.agency.entities.Account;
import ma.atos.agency.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){

        this.accountRepository = accountRepository;
    }
    public Account getAccount(String accountNumber){
        return (Account) accountRepository;
    }
}
