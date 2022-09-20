package com.programeiros.thisfinans.model.mapper;

import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.model.entities.Account;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    Account toEntity(AccountDTO accountDTO);
    AccountDTO toDto(Account account);
    List<Account> toEntityList(List<AccountDTO> accountDTOList);
    List<AccountDTO> toDtoList(List<Account> accountList);
}
