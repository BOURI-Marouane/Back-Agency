package ma.atos.agency.services;

import ma.atos.agency.dto.AccountDto;

import ma.atos.agency.entities.Account;


import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface IAccount {
    List<AccountDto> getAll();
    Account newAccount(AccountDto accountDto);
    AccountDto getAccount(Long id) throws AccountNotFoundException;
    Account replaceAccount(AccountDto newAccountDto,Long id) throws AccountNotFoundException;
    void deleteAccount(Long id) throws AccountNotFoundException;

}
