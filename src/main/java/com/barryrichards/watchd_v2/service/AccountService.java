package com.barryrichards.watchd_v2.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.barryrichards.watchd_v2.model.Account;
import com.barryrichards.watchd_v2.repository.AccountRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountService {
    
    private AccountRepository accountRepository;

    public Account findById(UUID id) {
        return accountRepository.findById(id).orElse(null);
    }
}
