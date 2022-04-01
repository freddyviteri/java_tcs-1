package com.pichicnha.com.cuenta.repository;

import com.pichicnha.com.cuenta.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
