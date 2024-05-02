package com.binary.uniTech.response.account;


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
public class AccountUpdateResponse {

    private String accountNumber;
    private BigDecimal balance;
    private Long fkUserId;
    private String status;

}
