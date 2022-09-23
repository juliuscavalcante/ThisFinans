package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.mappers.AccountMapper;
import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.model.entities.Account;
import com.programeiros.thisfinans.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Transactional
    public AccountDTO findById(Long id) throws ChangeSetPersister.NotFoundException {
        Account account = accountRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.entityToDto(account);
    }

    @Transactional
    public Account save(AccountDTO accountDTO) throws Exception {
        Account account = new Account(accountDTO);
        return accountRepository.save(account);
    }
}
