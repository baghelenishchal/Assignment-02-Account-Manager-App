package com.backbase.assignment.account_management.controller;

import com.backbase.assignment.account_management.entity.Account;
import com.backbase.assignment.account_management.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Get all accounts with pagination
    @GetMapping
    public List<Account> getAllAccounts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return accountService.getAllAccounts(page, size);
    }

    // Get account by account number or name
    @GetMapping("/filter")
    public ResponseEntity<Account> getAccountByFilter(
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String accountName) {
        if (accountNumber != null) {
            Optional<Account> account = accountService.getAccountByNumber(accountNumber);
            return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } else if (accountName != null) {
            Optional<Account> account = accountService.getAccountByName(accountName);
            return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            log.error("Bad Request: Atleast one parameter is required for data filtration" );
            return ResponseEntity.badRequest().build();
        }
    }

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    // Update an existing account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(id, accountDetails);
        return ResponseEntity.ok(updatedAccount);
    }
}

