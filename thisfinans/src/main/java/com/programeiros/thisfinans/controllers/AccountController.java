package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.exceptions.business.AccountNameRuleException;
import com.programeiros.thisfinans.exceptions.business.AccountNameRuleWithParamsException;
import com.programeiros.thisfinans.model.dto.AccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
public class AccountController {

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
}
