package com.programeiros.thisfinans.model.mapper;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target="account.id", source="accountId")
    Transaction toEntity(TransactionDTO transactionDTO);

    @Mapping(target="accountId", source="account.id")
    TransactionDTO toDto(Transaction transaction);

}
