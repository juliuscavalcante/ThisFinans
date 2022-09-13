package com.programeiros.thisfinans.repositories;

import com.programeiros.thisfinans.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRespository extends JpaRepository<Account, Long> {

}
