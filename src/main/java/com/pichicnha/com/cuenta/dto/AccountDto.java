package com.pichicnha.com.cuenta.dto;

import com.pichicnha.com.cuenta.model.Account;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private long id;
    private String name;
    private String code;

    public Account toEntity() { return new Account(id,name,code);}
}
