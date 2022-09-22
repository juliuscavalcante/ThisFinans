package com.programeiros.thisfinans.model.mapper;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactionMapper.class);
    Transaction toEntity(TransactionDTO transactionDTO);
    TransactionDTO toDto(Transaction transaction);

}
