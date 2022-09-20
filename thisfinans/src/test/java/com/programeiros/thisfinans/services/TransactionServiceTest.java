package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.model.enums.TransactionStatus;
import com.programeiros.thisfinans.model.enums.TransactionType;
import com.programeiros.thisfinans.repositories.TransactionRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {


    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    TransactionService underTest;

    Transaction transaction = new Transaction(22L,UUID.randomUUID(),"Teste",TransactionType.EXPENSES,TransactionStatus.COMPLETE,BigDecimal.valueOf(20),Boolean.FALSE,Instant.now(),Instant.now(),Instant.now(),null);

//    @Test
//    void itShouldFindAll() {
//        //when
//        underTest.findAll();
//        //then
//        verify(transactionRepository).findAll();
//    }
//
//    @Test
//    void itShouldFindById() {
//
//       when(transactionRepository.findById(any())).thenReturn(Optional.of(transaction));
//       TransactionDTO testTransaction = underTest.findById(1L);
//
//       assertEquals(transaction.getId(), testTransaction.getId());
//       assertEquals(transaction.getCod(), testTransaction.getCod());
//       assertEquals(transaction.getDescription(), testTransaction.getDescription());
//       assertEquals(transaction.getType(), testTransaction.getType());
//       assertEquals(transaction.getAmount(), testTransaction.getAmount());
//       assertEquals(transaction.getDeleted(), testTransaction.getDeleted());
//       assertEquals(transaction.getTransactionDate(), testTransaction.getTransactionDate());
//       assertEquals(transaction.getCreateDate(), testTransaction.getCreateDate());
//       assertEquals(transaction.getUpdateDate(), testTransaction.getUpdateDate());
//       assertEquals(transaction.getAccountTransactions(), testTransaction.getAccountTransactions());
//
//    }
//
//    @Test
//    void itShouldDelete() {
//        when(transactionRepository.findById(any())).thenReturn(Optional.of(transaction));
//
//        underTest.delete(1L);
//
//        verify(transactionRepository, times(1)).delete(transaction);
//    }
//
////    @Test
//    void itShouldInsert() {
////        TransactionDTO transactionDTO = TransactionDTO.entityToDto(transaction);
////        //when
////        underTest.insert(transactionDTO);
////
////        //then
////        ArgumentCaptor<Transaction> transactionArgumentCaptor = ArgumentCaptor.forClass(Transaction.class);
////
////        verify(transactionRepository).save(transactionArgumentCaptor.capture());
////
////        TransactionDTO capturedTransaction = TransactionDTO.entityToDto(transactionArgumentCaptor.getValue());
////
////        assertEquals(capturedTransaction.getId(), transactionDTO.getId());
////        assertEquals(capturedTransaction.getCod(), transactionDTO.getCod());
////        assertEquals(capturedTransaction.getDescription(), transactionDTO.getDescription());
////        assertEquals(capturedTransaction.getType(), transactionDTO.getType());
////        assertEquals(capturedTransaction.getAmount(), transactionDTO.getAmount());
////        assertEquals(capturedTransaction.getDeleted(), transactionDTO.getDeleted());
////        assertEquals(capturedTransaction.getTransactionDate(), transactionDTO.getTransactionDate());
////        assertEquals(capturedTransaction.getCreateDate(), transactionDTO.getCreateDate());
////        assertEquals(capturedTransaction.getUpdateDate(), transactionDTO.getUpdateDate());
////        assertEquals(capturedTransaction.getAccountTransactions(), transactionDTO.getAccountTransactions());
//
//    }
//
////    @Test
//    void itShouldUpdateTheTransaction() {
//
////        TransactionDTO changes = new TransactionDTO(14L,UUID.randomUUID(),"Hello, world!",TransactionType.REVENUE,TransactionStatus.OPEN,BigDecimal.valueOf(10),Boolean.TRUE,Instant.now(),Instant.now(),Instant.now(),null);
////
////        when(transactionRepository.findById(any())).thenReturn(Optional.of(transaction));
////
////        TransactionDTO changedTransaction = underTest.update(changes);
////
////        assertEquals(changedTransaction.getId(), changes.getId());
////        assertEquals(changedTransaction.getCod(), changes.getCod());
////        assertEquals(changedTransaction.getDescription(), changes.getDescription());
////        assertEquals(changedTransaction.getType(), changes.getType());
////        assertEquals(changedTransaction.getAmount(), changes.getAmount());
////        assertEquals(changedTransaction.getDeleted(), changes.getDeleted());
////        assertEquals(changedTransaction.getTransactionDate(), changes.getTransactionDate());
////        assertEquals(changedTransaction.getCreateDate(), changes.getCreateDate());
////        assertEquals(changedTransaction.getUpdateDate(), changes.getUpdateDate());
////        assertEquals(changedTransaction.getAccountTransactions(), changes.getAccountTransactions());
//    }
//
////    @Test
//    void willUpdateData() {
////        TransactionDTO changes = new TransactionDTO(14L,UUID.randomUUID(),"Hello, world!",TransactionType.REVENUE,TransactionStatus.OPEN,BigDecimal.valueOf(10),Boolean.TRUE,Instant.now(),Instant.now(),Instant.now(),null);
////
////
////        Transaction changedTransaction = underTest.updateData(transaction, changes);
////
////        assertEquals(changedTransaction.getId(), changes.getId());
////        assertEquals(changedTransaction.getCod(), changes.getCod());
////        assertEquals(changedTransaction.getDescription(), changes.getDescription());
////        assertEquals(changedTransaction.getType(), changes.getType());
////        assertEquals(changedTransaction.getAmount(), changes.getAmount());
////        assertEquals(changedTransaction.getDeleted(), changes.getDeleted());
////        assertEquals(changedTransaction.getTransactionDate(), changes.getTransactionDate());
////        assertEquals(changedTransaction.getCreateDate(), changes.getCreateDate());
////        assertEquals(changedTransaction.getUpdateDate(), changes.getUpdateDate());
////        assertEquals(changedTransaction.getAccountTransactions(), changes.getAccountTransactions());
//
//    }
//
////    @Test
//    void convertFromDTO() {
////        TransactionDTO test = TransactionDTO.entityToDto(transaction);
////
////        Transaction changedTransaction = underTest.convertFromDTO(test);
////
////        assertEquals(changedTransaction.getId(), transaction.getId());
////        assertEquals(changedTransaction.getCod(), transaction.getCod());
////        assertEquals(changedTransaction.getDescription(), transaction.getDescription());
////        assertEquals(changedTransaction.getType(), transaction.getType());
////        assertEquals(changedTransaction.getAmount(), transaction.getAmount());
////        assertEquals(changedTransaction.getDeleted(), transaction.getDeleted());
////        assertEquals(changedTransaction.getTransactionDate(), transaction.getTransactionDate());
////        assertEquals(changedTransaction.getCreateDate(), transaction.getCreateDate());
////        assertEquals(changedTransaction.getUpdateDate(), transaction.getUpdateDate());
////        assertEquals(changedTransaction.getAccountTransactions(), transaction.getAccountTransactions());
//    }
}