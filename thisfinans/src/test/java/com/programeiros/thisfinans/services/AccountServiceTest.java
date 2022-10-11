package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.model.entities.Account;
import com.programeiros.thisfinans.model.enums.AccountType;
import com.programeiros.thisfinans.model.mappers.AccountMapper;
import com.programeiros.thisfinans.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Spy
    private final AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    @BeforeEach
    void setUp() {

    }

    @Test
    @Disabled
    void shouldReturnFindlAllAccounts() {
    }

    @Test
    @Disabled
    void findById() {
    }

    @Test
    @Disabled
    void shouldSavedAccount() {
        /*AccountDTO accountDTO = AccountDTO.builder()
                .id(1L)
                .cod(UUID.randomUUID())
                .name("Account test")
                .type(AccountType.WALLET)
                .deleted(false)
                .createDate(Instant.from(LocalDate.now()))
                .build();

        Account account = accountMapper.dtoToEntity(accountDTO);*/
    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    @Disabled
    void delete() {
    }
}