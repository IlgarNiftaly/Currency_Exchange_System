package com.binary.uniTech.response.account;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDeleteResponse {

    private String accountNumber;
    private BigDecimal balance;
    private Long fkUserId;
    private String status;

}
