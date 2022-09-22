package com.programeiros.thisfinans.model.mapper;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactionMapper.class);
    @Mapping(target = "accountTransactions", ignore = true)
    Transaction toEntity(TransactionDTO transactionDTO);
    @Mapping(target = "accountTransactions", ignore = true)
    TransactionDTO toDto(Transaction transaction);

}
