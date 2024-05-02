package com.binary.uniTech.request.account;


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
public class AccountDeleteRequest {

    private Long id;
    private String accountNumber;

}
