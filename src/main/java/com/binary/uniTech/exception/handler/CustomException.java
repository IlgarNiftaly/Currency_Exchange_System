package com.binary.uniTech.exception.handler;

import com.binary.uniTech.exception.UserConflictException;
import com.binary.uniTech.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class CustomException {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ProblemDetail handlerUserNotFoundException(Exception exception){
        log.info("handlerUserNotFoundException {}", exception.getMessage());
        return ProblemDetail.forStatusAndDetail(NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(UserConflictException.class)
    @ResponseStatus(CONFLICT)
    public ProblemDetail handlerUserConflictException(Exception exception){
        log.info("handlerUserConflictException {}", exception.getMessage());
        return ProblemDetail.forStatusAndDetail(CONFLICT, exception.getMessage());
    }
}
