package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.model.enums.TransactionStatus;
import com.programeiros.thisfinans.model.enums.TransactionType;
import com.programeiros.thisfinans.repositories.TransactionRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {


    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    TransactionService underTest;


    @BeforeEach
    void setUp() {
        underTest = new TransactionService(transactionRepository);
    }

    @Test
    void canFindAll() {
        //when
        underTest.findAll();
        //then
        verify(transactionRepository).findAll();
    }

    @Test
    void canItFindById() {
        Transaction transaction = new Transaction(22L,UUID.randomUUID(),"Teste",TransactionType.EXPENSES,TransactionStatus.COMPLETE,BigDecimal.valueOf(20),Boolean.FALSE,Instant.now(),Instant.now(),Instant.now(),null);

       when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
       TransactionDTO testTransaction = underTest.findById(1L);

       assertEquals(transaction.getId(), testTransaction.getId());
       assertEquals(transaction.getCod(), testTransaction.getCod());
       assertEquals(transaction.getDescription(), testTransaction.getDescription());
       assertEquals(transaction.getType(), testTransaction.getType());
       assertEquals(transaction.getAmount(), testTransaction.getAmount());
       assertEquals(transaction.getDeleted(), testTransaction.getDeleted());
       assertEquals(transaction.getTransactionDate(), testTransaction.getTransactionDate());
       assertEquals(transaction.getCreateDate(), testTransaction.getCreateDate());
       assertEquals(transaction.getUpdateDate(), testTransaction.getUpdateDate());
       assertEquals(transaction.getAccountTransactions(), testTransaction.getAccountTransactions());


//        this.id = entity.getId();
//        this.cod = entity.getCod();
//        this.description = entity.getDescription();
//        this.type = entity.getType();
//        this.amount = entity.getAmount();
//        this.deleted = entity.getDeleted();
//        this.transactionDate = entity.getTransactionDate();
//        this.createDate = entity.getCreateDate();
//        this.updateDate = entity.getUpdateDate();
//        this.accountTransactions = entity.getAccountTransactions();

    }
}