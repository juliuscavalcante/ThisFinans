package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
