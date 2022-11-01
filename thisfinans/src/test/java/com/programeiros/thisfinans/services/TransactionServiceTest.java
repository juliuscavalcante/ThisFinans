package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.model.enums.TransactionStatus;
import com.programeiros.thisfinans.model.enums.TransactionType;
import com.programeiros.thisfinans.model.mapper.TransactionMapper;
import com.programeiros.thisfinans.repositories.TransactionRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {


    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    TransactionService underTest;

    Transaction transaction;

    @BeforeEach
    void beforeEach(){
        transaction = new Transaction(
                22L,
                UUID.randomUUID(),
                "Teste",
                TransactionType.EXPENSES,
                TransactionStatus.COMPLETE,
                BigDecimal.valueOf(20),
                Boolean.FALSE,
                Instant.now(),
                Instant.now(),
                Instant.now(),
                null,
                null,
                null);
    }

    @Test
    void itShouldFindAll() {
        //when
        underTest.findAll();
        //then
        verify(transactionRepository).findAll();
    }

    @Test
    void itShouldFindById() {

       when(transactionRepository.findById(22L)).thenReturn(Optional.of(transaction));

       TransactionDTO testTransaction = underTest.findByIdOrThrowBadRequestException(22L);

       assertEquals(transaction.getId(), testTransaction.getId());
       assertEquals(transaction.getCod(), testTransaction.getCod());
       assertEquals(transaction.getDescription(), testTransaction.getDescription());
       assertEquals(transaction.getType(), testTransaction.getType());
       assertEquals(transaction.getAmount(), testTransaction.getAmount());
       assertEquals(transaction.getStatus(), testTransaction.getStatus());
       assertEquals(transaction.getTransactionDate(), testTransaction.getTransactionDate());
//       assertEquals(transaction.getTransactionDays(), testTransaction.getTransactionDays());
//       assertEquals(transaction.getTransactionEntries(), testTransaction.getTransactionEntries());
    }

    @Test
    void itShouldDelete() {
        when(transactionRepository.findById(22L)).thenReturn(Optional.of(transaction));

        underTest.delete(22L);

        verify(transactionRepository, times(1)).delete(transaction);
    }

    @Test
    void itShouldInsert() {
        TransactionDTO transactionDTO = TransactionMapper.INSTANCE.toDto(transaction);

        //when
        underTest.insert(transactionDTO);

        //then
        ArgumentCaptor<Transaction> transactionArgumentCaptor = ArgumentCaptor.forClass(Transaction.class);

        verify(transactionRepository, times(1)).save(transactionArgumentCaptor.capture());

        Transaction capturedTransaction = transactionArgumentCaptor.getValue();

        assertNotNull(capturedTransaction.getCod());
        assertEquals(TransactionStatus.OPEN, capturedTransaction.getStatus());
        assertEquals(transactionDTO.getId(), capturedTransaction.getId());
        assertEquals(transactionDTO.getCod(), capturedTransaction.getCod());
        assertEquals(transactionDTO.getDescription(), capturedTransaction.getDescription());
        assertEquals(transactionDTO.getType(), capturedTransaction.getType());
        assertEquals(transactionDTO.getAmount(), capturedTransaction.getAmount());
        assertEquals(transactionDTO.getTransactionDate(), capturedTransaction.getTransactionDate());
    }

    @Test
    void itShouldUpdateTheTransaction() {
        TransactionDTO transactionDTO = TransactionMapper.INSTANCE.toDto(transaction);

        TransactionDTO changedTransaction = underTest.update(transactionDTO);

        verify(transactionRepository, times(1)).save(transaction);

        assertEquals(transactionDTO.getId(), changedTransaction.getId());
        assertEquals(transactionDTO.getCod(), changedTransaction.getCod());
        assertEquals(transactionDTO.getDescription(), changedTransaction.getDescription());
        assertEquals(transactionDTO.getType(), changedTransaction.getType());
        assertEquals(transactionDTO.getAmount(), changedTransaction.getAmount());
        assertEquals(transactionDTO.getTransactionDate(), changedTransaction.getTransactionDate());
    }

    @Test
    void willUpdateData() {
//        TransactionDTO changes = new TransactionDTO(14L,UUID.randomUUID(),"Hello, world!",TransactionType.REVENUE,TransactionStatus.OPEN,BigDecimal.valueOf(10),Boolean.TRUE,Instant.now(),Instant.now(),Instant.now(),null);
//
//
//        Transaction changedTransaction = underTest.updateData(transaction, changes);
//
//        assertEquals(changedTransaction.getId(), changes.getId());
//        assertEquals(changedTransaction.getCod(), changes.getCod());
//        assertEquals(changedTransaction.getDescription(), changes.getDescription());
//        assertEquals(changedTransaction.getType(), changes.getType());
//        assertEquals(changedTransaction.getAmount(), changes.getAmount());
//        assertEquals(changedTransaction.getDeleted(), changes.getDeleted());
//        assertEquals(changedTransaction.getTransactionDate(), changes.getTransactionDate());
//        assertEquals(changedTransaction.getCreateDate(), changes.getCreateDate());
//        assertEquals(changedTransaction.getUpdateDate(), changes.getUpdateDate());
//        assertEquals(changedTransaction.getAccountTransactions(), changes.getAccountTransactions());

    }

    @Test
    void convertFromDTO() {
//        TransactionDTO test = TransactionDTO.entityToDto(transaction);
//
//        Transaction changedTransaction = underTest.convertFromDTO(test);
//
//        assertEquals(changedTransaction.getId(), transaction.getId());
//        assertEquals(changedTransaction.getCod(), transaction.getCod());
//        assertEquals(changedTransaction.getDescription(), transaction.getDescription());
//        assertEquals(changedTransaction.getType(), transaction.getType());
//        assertEquals(changedTransaction.getAmount(), transaction.getAmount());
//        assertEquals(changedTransaction.getDeleted(), transaction.getDeleted());
//        assertEquals(changedTransaction.getTransactionDate(), transaction.getTransactionDate());
//        assertEquals(changedTransaction.getCreateDate(), transaction.getCreateDate());
//        assertEquals(changedTransaction.getUpdateDate(), transaction.getUpdateDate());
//        assertEquals(changedTransaction.getAccountTransactions(), transaction.getAccountTransactions());
    }
}