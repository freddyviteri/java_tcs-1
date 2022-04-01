package com.pichicnha.com.cuenta.services;

import com.pichicnha.com.cuenta.dto.AccountDto;
import com.pichicnha.com.cuenta.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public List<AccountDto> getAccounts();

    public AccountDto saveAccount(AccountDto account);

    public AccountDto update(AccountDto account, long id) throws ResourceNotFoundException;

    public void deleteAccount(long id) throws ResourceNotFoundException;

    public Optional<AccountDto> findAccount(long id);
}
