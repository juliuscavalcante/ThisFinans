package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.DB.DBException;
import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.model.enums.TransactionStatus;
import com.programeiros.thisfinans.model.mapper.TransactionMapper;
import com.programeiros.thisfinans.repositories.TransactionRepository;
import com.programeiros.thisfinans.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;

    public List<TransactionDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(TransactionMapper.INSTANCE::toDto)
                .toList();
    }

    public TransactionDTO findByIdOrThrowBadRequestException(Long id) {
        Optional<Transaction> transaction = repository.findById(id);

        return TransactionMapper.INSTANCE.toDto(transaction.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Transaction not found, Id: " + id)));
    }

    public void delete(Long id) {
        try {
            repository.findById(id).ifPresent(repository::delete);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DBException(ex.getMessage());
        }
    }

    public TransactionDTO insert(TransactionDTO transactionDTO) {
        transactionDTO.setCod(UUID.randomUUID());
        transactionDTO.setStatus(TransactionStatus.OPEN);
        return TransactionMapper.INSTANCE.toDto(
                repository.save(TransactionMapper.INSTANCE.toEntity(transactionDTO))
        );
    }

    public TransactionDTO update(TransactionDTO transactionDTO) {
        Transaction transaction = TransactionMapper.INSTANCE.toEntity(transactionDTO);

        repository.save(transaction);

        return TransactionMapper.INSTANCE.toDto(transaction);
    }
}
