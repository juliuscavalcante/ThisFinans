package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.DB.DBException;
import com.programeiros.thisfinans.model.dto.TransactionDaysDTO;
import com.programeiros.thisfinans.model.entities.TransactionDays;
import com.programeiros.thisfinans.model.mapper.TransactionDaysMapper;
import com.programeiros.thisfinans.repositories.TransactionDaysRepository;
import com.programeiros.thisfinans.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionDaysService {

    private final TransactionDaysRepository repository;

    public List<TransactionDaysDTO> listAllDays() {
        return repository.findAll()
                .stream()
                .map(TransactionDaysMapper.INSTANCE::toDTO)
                .toList();
    }

    public TransactionDaysDTO findDayByIdOrThrowException(Long id) {
        TransactionDays foundDay = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Day not found, Id: " + id));
        return TransactionDaysMapper.INSTANCE.toDTO(foundDay);

    }

    public TransactionDays addingNewDay(TransactionDaysDTO transactionDaysDTO) {
        return repository.save(TransactionDaysMapper.INSTANCE.toEntity(transactionDaysDTO));
    }

    public void replaceTheDay(TransactionDaysDTO day) {
        findDayByIdOrThrowException(day.getId());
        addingNewDay(day);
    }

    public void deleteDay(Long id) {
        try {
            repository.findById(id).ifPresent(repository::delete);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DBException(ex.getMessage());
        }
    }
}
