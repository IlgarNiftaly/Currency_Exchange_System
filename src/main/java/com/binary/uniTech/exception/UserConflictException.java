package com.binary.uniTech.exception;

public class UserConflictException extends RuntimeException{

    public UserConflictException(String code, String message){
        super(message);
    }
}
