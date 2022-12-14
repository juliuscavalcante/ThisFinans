package com.programeiros.thisfinans.model.mapper;

import com.programeiros.thisfinans.model.dto.TransactionDaysDTO;
import com.programeiros.thisfinans.model.entities.TransactionDays;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.transaction.Transactional;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionDaysMapper {

    TransactionDaysMapper INSTANCE = Mappers.getMapper(TransactionDaysMapper.class);
    @Transactional
    @Mapping(target = "transaction.id", source = "transactionId")
    TransactionDays toEntity(TransactionDaysDTO transactionDaysDTO);
    @Transactional
    @Mapping(target = "transactionId", source = "transaction.id")
    TransactionDaysDTO toDTO(TransactionDays transactionDays);

    List<TransactionDays> toEntityList(List<TransactionDaysDTO> transactionDaysDTOList);
    List<TransactionDaysDTO> toDTOList(List<TransactionDays> transactionDaysList);
}
