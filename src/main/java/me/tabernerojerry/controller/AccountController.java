package me.tabernerojerry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/my-account")
    public String getAccountDetails() {
        return "Account details from the database";
    }

}