package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.TransactionDaysDTO;
import com.programeiros.thisfinans.model.entities.TransactionDays;
import com.programeiros.thisfinans.model.mapper.TransactionDaysMapper;
import com.programeiros.thisfinans.repositories.TransactionDaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionDaysService {

    private final TransactionDaysRepository repository;

    public List<TransactionDaysDTO> findAll() {
        return TransactionDaysMapper.INSTANCE.toDTOList(repository.findAll());
    }

    public TransactionDays insert(TransactionDaysDTO transactionDaysDTO) {
        return repository.save(TransactionDaysMapper.INSTANCE.toEntity(transactionDaysDTO));
    }
}
