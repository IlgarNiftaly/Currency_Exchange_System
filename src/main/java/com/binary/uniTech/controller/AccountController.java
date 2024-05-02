package com.binary.uniTech.controller;


import com.binary.uniTech.request.account.AccountCreateRequest;
import com.binary.uniTech.response.account.AccountCreateResponse;
import com.binary.uniTech.service.account.AccountCreateService;
import com.binary.uniTech.service.account.AccountDeleteService;
import com.binary.uniTech.service.account.AccountReadService;
import com.binary.uniTech.service.account.AccountUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountCreateService createService;
//    private final AccountReadService readService;
//    private final AccountUpdateService updateService;
//    private final AccountDeleteService deleteService;


    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountCreateResponse> create(@RequestBody @Valid AccountCreateRequest createRequest){
        return ResponseEntity.ok(createService.create(createRequest));
    }

}
