package com.programeiros.thisfinans.model.mapper;

import com.programeiros.thisfinans.model.dto.TransactionDTO;
import com.programeiros.thisfinans.model.dto.TransactionEntryDTO;
import com.programeiros.thisfinans.model.entities.TransactionEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionEntryMapper {

    TransactionEntryMapper INSTANCE = Mappers.getMapper(TransactionEntryMapper.class);

    @Mapping(target = "account.id", source = "accountId")
    @Mapping(target = "transaction.id", source = "transactionId")
    TransactionEntry toEntity(TransactionEntryDTO transactionEntryDTO);

    @Mapping(target = "accountId", source = "account.id")
    @Mapping(target = "transactionId", source = "transaction.id")
    TransactionEntryDTO toDTO(TransactionEntry transactionEntry);
}
