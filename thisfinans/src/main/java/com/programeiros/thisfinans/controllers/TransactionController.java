package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.model.mapper.TransactionMapper;
import com.programeiros.thisfinans.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll() {
        List<TransactionDTO> transactionDTOList = transactionService.findAll();

        return ResponseEntity.ok().body(transactionDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable Long id) {
        TransactionDTO transactionDTO = transactionService.findById(id);

        return ResponseEntity.ok().body(transactionDTO);
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> insert(@RequestBody @Valid TransactionDTO transactionDTO) {
        Transaction newTransaction = transactionService.insert(transactionDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(TransactionMapper.TRANSACTION_MAPPER.toDto(newTransaction));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TransactionDTO> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        TransactionDTO transactionDTO = transactionService.update(TransactionMapper.TRANSACTION_MAPPER.toDto(transaction));

        return ResponseEntity.ok().body(transactionDTO);
    }
}
