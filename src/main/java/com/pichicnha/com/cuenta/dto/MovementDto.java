package com.pichicnha.com.cuenta.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovementDto {
    private long id;
    private String name;
    private AccountDto accountDto;
}
