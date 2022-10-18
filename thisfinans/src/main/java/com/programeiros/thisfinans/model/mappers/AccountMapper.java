package com.programeiros.thisfinans.model.mappers;

import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.model.entities.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    Account dtoToEntity(AccountDTO accountdto);
    AccountDTO entityToDto(Account account);
}
