package com.binary.uniTech.request.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountReadRequest {

    private Long id;
    private String accountNumber;
    private Long fkUserId;
    private String status;

}
