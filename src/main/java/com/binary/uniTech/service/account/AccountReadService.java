package com.binary.uniTech.service.account;

import com.binary.uniTech.exception.AccountNotFoundException;
import com.binary.uniTech.mapper.AccountMapper;
import com.binary.uniTech.repository.AccountRepository;
import com.binary.uniTech.request.account.AccountReadRequest;
import com.binary.uniTech.response.account.AccountReadResponse;
import com.binary.uniTech.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountReadService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AuthenticationService authenticationService;

    public List<AccountReadResponse> readAll(){
        return accountMapper.listEntityToListResponse(accountRepository.findAll());
    }

    public AccountReadResponse readByAccountNumber(AccountReadRequest readRequest){
        if(authenticationService.checkAccountWithAccountNumber(readRequest.getAccountNumber())){
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.name(), "this accountNumber does not exist");
        }
        return accountMapper.readToResponse(accountRepository.findByAccountNumber(String.valueOf(readRequest)));
    }

    public AccountReadResponse readByFkUserId(AccountReadRequest readRequest){
        if(authenticationService.checkAccountWithFkUserId(readRequest.getFkUserId())){
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.name(), "this fkUserId does not exist");
        }
        return accountMapper.readToResponse(accountRepository.findByFkUserId(readRequest.getFkUserId()));
    }

    public AccountReadResponse readByStatus(AccountReadRequest readRequest){
        if(authenticationService.checkAccountWithStatus(readRequest.getStatus())){
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.name(), "this status does not exist");
        }
        return accountMapper.readToResponse(accountRepository.findByStatus(readRequest.getStatus()));
    }
}
