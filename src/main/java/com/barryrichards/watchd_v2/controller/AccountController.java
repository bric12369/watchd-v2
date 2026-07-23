package com.barryrichards.watchd_v2.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.barryrichards.watchd_v2.model.Account;
import com.barryrichards.watchd_v2.service.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AccountController {

    private AccountService accountService;
    
    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable UUID id) {
        return accountService.findById(id);
    }
}
