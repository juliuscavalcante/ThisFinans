package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.model.dto.TransactionDaysDTO;
import com.programeiros.thisfinans.model.entities.TransactionDays;
import com.programeiros.thisfinans.model.mapper.TransactionDaysMapper;
import com.programeiros.thisfinans.services.TransactionDaysService;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
    public ResponseEntity<List<TransactionDaysDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionDaysDTO> save(@RequestBody @Valid TransactionDaysDTO transactionDaysDTO) {
        TransactionDays savedTransactionDays = service.insert(transactionDaysDTO);

        return new  ResponseEntity<>(TransactionDaysMapper.INSTANCE.toDTO(savedTransactionDays), HttpStatus.CREATED);
    }
}
