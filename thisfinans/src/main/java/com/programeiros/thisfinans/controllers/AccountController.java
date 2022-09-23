package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.exceptions.business.AccountNameRuleException;
import com.programeiros.thisfinans.exceptions.business.AccountNameRuleWithParamsException;
import com.programeiros.thisfinans.model.entities.Account;
import com.programeiros.thisfinans.model.mappers.AccountMapper;
import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


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
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody @Valid AccountDTO accountDTO) throws Exception {
        Account newAccount = accountService.save(accountDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newAccount.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getOneAccount(@PathVariable(value = "id") Long id) throws NotFoundException {
        AccountDTO accountDTO = accountService.findById(id);
        return ResponseEntity.accepted().body(accountDTO);
    }
}
