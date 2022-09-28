package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.mappers.AccountMapper;
import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.model.entities.Account;
import com.programeiros.thisfinans.repositories.AccountRepository;
import com.programeiros.thisfinans.services.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Transactional
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Transactional
    public Account findById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        return accountOptional.orElseThrow(() -> new ObjectNotFoundException("technician id " + id + " not found"));
    }

    @Transactional
    public Account save(AccountDTO accountDTO) throws Exception {
        Account account = new Account(accountDTO);
        return accountRepository.save(account);
    }

    @Transactional
    public Account update(Long id, @Valid AccountDTO accountDTO) {
        accountDTO.setId(id);
        Account account;
        account = new Account(accountDTO);
        return accountRepository.save(account);
    }

    @Transactional
    public void delete(Long id) throws NotFoundException {
        Account account = findById(id);
        accountRepository.deleteById(id);
    }
}
