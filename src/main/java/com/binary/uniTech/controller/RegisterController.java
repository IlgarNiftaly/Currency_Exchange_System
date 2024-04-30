package com.binary.uniTech.controller;


import com.binary.uniTech.request.user.UserRegisterRequest;
import com.binary.uniTech.response.user.UserRegisterResponse;
import com.binary.uniTech.service.user.UserRegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class RegisterController {
    private final UserRegisterService registerService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserRegisterResponse> register(@RequestBody @Valid UserRegisterRequest registerRequest){
        return ResponseEntity.ok(registerService.register(registerRequest));
    }
}
