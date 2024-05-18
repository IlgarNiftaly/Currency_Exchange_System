package com.binary.uniTech.service.authentication;

import com.binary.uniTech.entity.Account;
import com.binary.uniTech.exception.AccountNotFoundException;
import com.binary.uniTech.exception.error.ErrorMessage;
import com.binary.uniTech.repository.AccountRepository;
import com.binary.uniTech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public Account checkAccountWithId(Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND));
    }

    public boolean checkAccountWithAccountNumber(String accountNumber){
//        if(Objects.isNull(accountRepository.findByAccountNumber(accountNumber))){
//            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.name(), "this accountNumber does not exist");
//        }
        return Objects.isNull(accountRepository.findByAccountNumber(accountNumber));
    }
    public boolean checkAccountWithFkUserId(Long fkUserId){
        return Objects.isNull(accountRepository.findByFkUserId(fkUserId));
    }
    public boolean checkAccountWithStatus(String status){
        return Objects.isNull(accountRepository.findByStatus(status));
    }

}
