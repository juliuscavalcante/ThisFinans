package com.programeiros.thisfinans.repositories;

import com.programeiros.thisfinans.model.entities.TransactionDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDaysRepository extends JpaRepository<TransactionDays, Long> {
}
