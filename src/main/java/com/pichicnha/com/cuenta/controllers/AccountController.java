package com.pichicnha.com.cuenta.controllers;

import com.pichicnha.com.cuenta.dto.AccountDto;
import com.pichicnha.com.cuenta.exception.ResourceNotFoundException;
import com.pichicnha.com.cuenta.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public List<AccountDto> getAccounts(){return  accountService.getAccounts();}
    @PostMapping()
    public ResponseEntity<?> postCountrie(@RequestBody AccountDto accountDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveAccount(accountDto));

    }

    @DeleteMapping("/{accountId}")
    private ResponseEntity<?> deleteAccount(@PathVariable("accountId") int id) {

        try {
            accountService.deleteAccount(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("id") Integer id, @RequestBody AccountDto accountDto) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(accountService.update(accountDto, id));
        } catch (ResourceNotFoundException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
