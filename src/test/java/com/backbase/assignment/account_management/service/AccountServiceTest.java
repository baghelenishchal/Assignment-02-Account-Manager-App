package com.backbase.assignment.account_management.service;

import com.backbase.assignment.account_management.entity.Account;
import com.backbase.assignment.account_management.repository.AccountRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    // Mock AccountRepository so that it's injected into the service
    @MockBean
    private AccountRepository accountRepository;

    // Inject the service to be tested
    @Autowired
    private AccountService accountService;

    @Test
    void testCreateAccount() {
        // Arrange
        Account account = new Account("12345", "Nishchal", 1000.0);
        when(accountRepository.save(any(Account.class))).thenReturn(account);

        // Act
        Account savedAccount = accountService.createAccount(account);

        // Assert
        assertNotNull(savedAccount);
        assertEquals("12345", savedAccount.getAccountNumber());
        verify(accountRepository, times(1)).save(any(Account.class));
    }
}


