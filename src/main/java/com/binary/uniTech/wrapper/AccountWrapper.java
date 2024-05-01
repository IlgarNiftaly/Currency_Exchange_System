package com.binary.uniTech.wrapper;

import com.binary.uniTech.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountWrapper {

    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Long fkUserId;
    private String status;

    public AccountWrapper(Long id, String accountNumber){
        this.id = id;
        this.accountNumber = accountNumber;
    }

    public AccountWrapper(Long id, String accountNumber, String status){
        this(id, accountNumber);
        this.status = status;
    }

}
