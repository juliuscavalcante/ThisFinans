package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.UserConfigDTO;
import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.entities.UserConfig;
import com.programeiros.thisfinans.model.mappers.UserConfigMapper;
import com.programeiros.thisfinans.model.mappers.UserMapper;
import com.programeiros.thisfinans.repositories.UserConfigRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserConfigService {

    private final UserConfigRepository repository;
    private final UserConfigMapper mapper;
    private final UserMapper userMapper;

    @Transactional
    public UserConfigDTO createAndSaveDefaultUserConfig(UserDTO userDTO){
        return mapper.toDto(
                repository.save(
                        UserConfig.builder()
                                .user(userMapper.dtoToEntity(userDTO))
                                .budgetClosingDay(5)
                                .build()));
    }
}
