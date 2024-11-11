package com.backbase.assignment.account_management.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class AccountControllerTest {

    @Autowired
    private AccountController accountController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
    void testCreateAccount() throws Exception {
        String json = "{ \"accountNumber\": \"12345\", \"accountName\": \"Nishchal\", \"balance\": 1000.0 }";

        mockMvc.perform(post("/api/accounts")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void testGetAccountByFilter() throws Exception {
        mockMvc.perform(get("/api/accounts/filter")
                        .param("accountNumber", "12345"))
                .andExpect(status().isOk());
    }
}

