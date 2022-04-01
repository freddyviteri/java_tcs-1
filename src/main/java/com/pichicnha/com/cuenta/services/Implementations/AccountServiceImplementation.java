package com.pichicnha.com.cuenta.services.Implementations;

import com.pichicnha.com.cuenta.dto.AccountDto;
import com.pichicnha.com.cuenta.exception.ResourceNotFoundException;
import com.pichicnha.com.cuenta.model.Account;
import com.pichicnha.com.cuenta.repository.AccountRepository;
import com.pichicnha.com.cuenta.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountServiceImplementation implements AccountService {
@Autowired
 private AccountRepository accountRepository;

 public List<AccountDto> getAccounts() {
  List<Account> objAccount =accountRepository.findAll();
  return objAccount.stream().map(c -> c.ToDto()).collect(Collectors.toList());
 }

 public AccountDto saveAccount(AccountDto accountDto) {
  return accountRepository.save(accountDto.toEntity()).ToDto();
 }

 public Optional<AccountDto> findAccount(long id) {

  Optional<Account>  objAccount = accountRepository.findById(id);
  Optional<AccountDto> objAccountDto;
  if(objAccount.isPresent()) {

   objAccountDto =  Optional.of(objAccount.get().ToDto());
  }
  else {
   objAccountDto = Optional.empty();
  }
  return objAccountDto;
 }

 public AccountDto update(AccountDto accountDto, long id) throws ResourceNotFoundException {
  Optional<AccountDto> find = findAccount(id);
  if (find.isPresent()) {
   Account objAccount = find.get().toEntity();
   objAccount.setName(accountDto.getName());
   objAccount.setCode(accountDto.getCode());
   return accountRepository.save(objAccount).ToDto();
  } else {
   throw new ResourceNotFoundException("Id not exists");
  }

 }

 public void deleteAccount(long id) throws ResourceNotFoundException {
  Optional<AccountDto> tutorialData = findAccount(id);
  if (tutorialData.isPresent()) {
   accountRepository.deleteById( id);
  } else {
   throw new ResourceNotFoundException("Id not exists");
  }
 }


}
