package com.programeiros.thisfinans.model.mappers;

import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User dtoToEntity(UserDTO userDTO);
    UserDTO entityToDto(User user);
}
