package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.exceptions.business.AccountNameRuleException;
import com.programeiros.thisfinans.exceptions.business.AccountNameRuleWithParamsException;
import com.programeiros.thisfinans.exceptions.mappers.AccountMapper;
import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper mapper;

    @PostMapping(path = "validation")
    public ResponseEntity<AccountDTO> accountValidationEndpoint(@Validated @RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountDTO);
    }

    @PostMapping(path = "business")
    public ResponseEntity<String> accountBusinessValidationEndpoint(@Validated @RequestBody AccountDTO accountDTO) {
        if (accountDTO.getName().equalsIgnoreCase("params")) {
            throw new AccountNameRuleWithParamsException("params");
        }
        if (!accountDTO.getName().equalsIgnoreCase("business")) {
            throw new AccountNameRuleException();
        }
        return ResponseEntity.ok("Success!");
    }

    @PostMapping
    public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDTO accountDTO) throws Exception {
        AccountDTO newAccount = accountService.save(accountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getOneAccount(@PathVariable(value = "id") Long id) throws NotFoundException {
        AccountDTO accountDTO = accountService.findById(id);
        return ResponseEntity.accepted().body(accountDTO);
    }
}
