package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.model.dto.TransactionDaysDTO;
import com.programeiros.thisfinans.model.entities.TransactionDays;
import com.programeiros.thisfinans.model.mapper.TransactionDaysMapper;
import com.programeiros.thisfinans.services.TransactionDaysService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("transaction-days")
@AllArgsConstructor
public class TransactionDaysController {

    private final TransactionDaysService service;

    @GetMapping
    public ResponseEntity<List<TransactionDaysDTO>> listAll() {
        return new ResponseEntity<>(service.listAllDays(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionDaysDTO> addANewDay(@RequestBody @Valid TransactionDaysDTO transactionDaysDTO) {
        TransactionDays savedTransactionDays = service.addingNewDay(transactionDaysDTO);

        return new  ResponseEntity<>(TransactionDaysMapper.INSTANCE.toDTO(savedTransactionDays), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody @Valid TransactionDaysDTO transactionDaysDTO) {
        service.replaceTheDay(transactionDaysDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDay(@PathVariable Long id) {
        service.deleteDay(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
