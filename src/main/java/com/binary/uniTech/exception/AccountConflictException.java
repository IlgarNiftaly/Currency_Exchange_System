package com.binary.uniTech.exception;

public class AccountConflictException extends RuntimeException{

    public AccountConflictException(String code, String message){
        super(message);
    }
}
