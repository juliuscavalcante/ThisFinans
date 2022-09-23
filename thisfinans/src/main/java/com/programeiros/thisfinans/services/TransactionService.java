package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.DB.DBException;
import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.model.enums.TransactionStatus;
import com.programeiros.thisfinans.model.mapper.TransactionMapper;
import com.programeiros.thisfinans.repositories.TransactionRepository;
import com.programeiros.thisfinans.services.exceptions.ResourceNotFoundException;
import com.programeiros.thisfinans.services.exceptions.ResourceNotFoundExceptionWithoutArgument;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    public List<TransactionDTO> findAll() {
        return repository.findAll().stream().map(x -> TransactionMapper.TRANSACTION_MAPPER.toDto(x)).toList();
    }

    public TransactionDTO findById(Long id) {
        Optional<Transaction> transaction = repository.findById(id);

        return mapper.toDto(transaction.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public void delete(Long id) {
        try {
            if(repository.findById(id).isPresent()) {
                repository.delete(repository.findById(id).get());
            }
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DBException(ex.getMessage());
        }
    }
    
    public TransactionDTO insert(TransactionDTO transactionDTO) {
        transactionDTO.setCod(UUID.randomUUID());
        transactionDTO.setStatus(TransactionStatus.OPEN);
        transactionDTO.setDeleted(Boolean.FALSE);
        return TransactionMapper.TRANSACTION_MAPPER.toDto(
                repository.save(TransactionMapper.TRANSACTION_MAPPER.toEntity(transactionDTO))
        );
    }

    public TransactionDTO update(TransactionDTO transactionDTO) {
            Transaction transaction = TransactionMapper.TRANSACTION_MAPPER.toEntity(transactionDTO);
            updateData(repository.findById(transaction.getId()).orElseThrow(ResourceNotFoundExceptionWithoutArgument::new), transactionDTO);

            repository.save(transaction);

            return mapper.toDto(transaction);
    }

    public Transaction updateData(Transaction transaction, TransactionDTO transactionDTO) {
        transaction.setId(transactionDTO.getId());
        transaction.setCod(transactionDTO.getCod());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setType(transactionDTO.getType());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDeleted(transactionDTO.getDeleted());
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        transaction.setCreateDate(transactionDTO.getCreateDate());
        transaction.setUpdateDate(transactionDTO.getUpdateDate());
//        transaction.setAccountTransactions(transactionDTO.getAccountTransactions());

        return transaction;
    }
}
