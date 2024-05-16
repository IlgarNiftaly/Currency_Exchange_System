package com.binary.uniTech.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/main")
public class MainController {

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(){
        return "secured part of the web service";
    }



}
