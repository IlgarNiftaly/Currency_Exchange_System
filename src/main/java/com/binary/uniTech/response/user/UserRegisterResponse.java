package com.binary.uniTech.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private Boolean emailVerified;
    private Long fkAccountId;

}
