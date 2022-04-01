package com.pichicnha.com.cuenta.model;

import com.pichicnha.com.cuenta.dto.AccountDto;
import com.pichicnha.com.cuenta.dto.MovementDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;

    public Account(long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code= code;
    }

    public AccountDto ToDto() {
        return new AccountDto(id,name,code);
    }

}
