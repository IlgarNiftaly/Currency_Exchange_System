package com.binary.uniTech.exception;

public class AccountBalanceException extends RuntimeException{

    public AccountBalanceException(String code, String message){
        super(message);
    }
}
