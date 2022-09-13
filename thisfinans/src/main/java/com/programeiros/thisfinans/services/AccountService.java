package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    Account insert(Account account);

    Account update(Account account);

    Optional<Account> findById(Long id);

    void delete(Long id);

    List<Account> findAll();
}
