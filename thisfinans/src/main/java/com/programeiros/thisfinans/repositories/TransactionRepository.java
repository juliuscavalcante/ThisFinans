package com.programeiros.thisfinans.repositories;

import com.programeiros.thisfinans.model.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
