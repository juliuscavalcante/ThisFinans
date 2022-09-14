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
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import javax.swing.text.html.parser.Entity;
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

    Transaction transaction = new Transaction(22L,UUID.randomUUID(),"Teste",TransactionType.EXPENSES,TransactionStatus.COMPLETE,BigDecimal.valueOf(20),Boolean.FALSE,Instant.now(),Instant.now(),Instant.now(),null);

    @Test
    void itShouldFindAll() {
        //when
        underTest.findAll();
        //then
        verify(transactionRepository).findAll();
    }

    @Test
    void itShouldFindById() {


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

    }

    @Test
    void itShouldDelete() {
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        underTest.delete(1L);

        verify(transactionRepository, times(1)).delete(transaction);
    }

    @Test
    void itShouldInsert() {
        //when
        underTest.insert(transaction);

        //then
        ArgumentCaptor<Transaction> transactionArgumentCaptor = ArgumentCaptor.forClass(Transaction.class);

        verify(transactionRepository).save(transactionArgumentCaptor.capture());

        TransactionDTO capturedTransaction = new TransactionDTO(transactionArgumentCaptor.getValue());

        assertEquals(capturedTransaction.getId(), transaction.getId());
        assertEquals(capturedTransaction.getCod(), transaction.getCod());
        assertEquals(capturedTransaction.getDescription(), transaction.getDescription());
        assertEquals(capturedTransaction.getType(), transaction.getType());
        assertEquals(capturedTransaction.getAmount(), transaction.getAmount());
        assertEquals(capturedTransaction.getDeleted(), transaction.getDeleted());
        assertEquals(capturedTransaction.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(capturedTransaction.getCreateDate(), transaction.getCreateDate());
        assertEquals(capturedTransaction.getUpdateDate(), transaction.getUpdateDate());
        assertEquals(capturedTransaction.getAccountTransactions(), transaction.getAccountTransactions());


    }
}