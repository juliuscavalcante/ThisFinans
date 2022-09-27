package com.programeiros.thisfinans.model.mapper;

import com.programeiros.thisfinans.model.dto.TransactionDaysDTO;
import com.programeiros.thisfinans.model.entities.TransactionDays;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionDaysMapper {

    TransactionDaysMapper INSTANCE = Mappers.getMapper(TransactionDaysMapper.class);

    @Mapping(target = "transaction.id", source = "transactionId")
    TransactionDays toEntity(TransactionDaysDTO transactionDaysDTO);

    @Mapping(target = "transactionId", source = "transaction.id")
    TransactionDaysDTO toDTO(TransactionDays transactionDays);
}
