package com.binary.uniTech.service.account;


import com.binary.uniTech.entity.Account;
import com.binary.uniTech.exception.AccountBalanceException;
import com.binary.uniTech.exception.AccountConflictException;
import com.binary.uniTech.exception.AccountNotFoundException;
import com.binary.uniTech.repository.AccountRepository;
import com.binary.uniTech.request.account.AccountTransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountTransferService {
    private final AccountRepository accountRepository;

    public void transferToAnyBankCard(AccountTransferRequest transferRequest){
        Account senderAccount = accountRepository.findByAccountNumber(transferRequest.getSenderAccountNumber());
        Account recipientAccount = accountRepository.findByAccountNumber(transferRequest.getRecipientAccountNumber());
        if(senderAccount == null){
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.name(), "this senderAccountNumber does not exist");
        }
        if(recipientAccount == null){
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.name(), "this recipientAccountNumber does not exist");
        }
        if(senderAccount.getAccountNumber().equals(recipientAccount.getAccountNumber())){
            throw new AccountConflictException(HttpStatus.CONFLICT.name(), "It is not possible to transfer between the same accountNumbers");
        }
        if(!recipientAccount.getStatus().equals("A")){
            throw new AccountConflictException(HttpStatus.CONFLICT.name(), "account is not active");
        }

        if(senderAccount.getBalance().compareTo(transferRequest.getSenderBalance()) < 0){
            throw new AccountBalanceException(HttpStatus.PAYMENT_REQUIRED.name(), "Your senderBalance does not have enough funds");
        }
        senderAccount.setBalance(senderAccount.getBalance().subtract(transferRequest.getSenderBalance()));
        recipientAccount.setBalance(recipientAccount.getBalance().add(transferRequest.getSenderBalance()));

        accountRepository.save(senderAccount);
        accountRepository.save(recipientAccount);
    }

}
