package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.dto.TransactionEntryDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<TransactionDTO> findAll() {
        return repository.findAll().stream().map(TransactionDTO::new).toList();
    }

    public TransactionDTO findById(Long id) {
        Optional<Transaction> transaction = repository.findById(id);

        return new TransactionDTO(transaction.get());
    }
}
