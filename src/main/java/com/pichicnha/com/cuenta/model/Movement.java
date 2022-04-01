package com.pichicnha.com.cuenta.model;

import com.pichicnha.com.cuenta.dto.AccountDto;
import com.pichicnha.com.cuenta.dto.MovementDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "accounts")

@Entity
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    private Account account;

    public MovementDto ToDto() {
        AccountDto accountDto = null;
        if(account != null) accountDto = account.ToDto();
        return new MovementDto(id,name,accountDto );
    }

}
