package com.barryrichards.watchd_v2.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barryrichards.watchd_v2.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Optional<Account> getByUsername(String username);
    Optional<Account> getByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
