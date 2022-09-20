package com.programeiros.thisfinans.model.mappers;

import com.programeiros.thisfinans.model.dto.UserConfigDTO;
import com.programeiros.thisfinans.model.entities.UserConfig;
import org.mapstruct.Mapper;

@Mapper
public interface UserConfigMapper {
    UserConfig toEntity(UserConfigDTO userConfigDTO);
    UserConfigDTO toDto(UserConfig userConfig);
}
