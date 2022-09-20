package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.UserConfigDTO;
import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.enums.UserType;
import com.programeiros.thisfinans.model.mappers.UserMapper;
import com.programeiros.thisfinans.repositories.UserRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserConfigService userConfigService;

    public UserService(UserRepository repository, UserMapper mapper, UserConfigService userConfigService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userConfigService = userConfigService;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) throws NotFoundException {
        User user = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.entityToDto(user);
    }

    @Transactional
    public UserDTO save(UserDTO userDTO) throws Exception {

        validateExistsUserByEmail(userDTO.getEmail());

        userDTO.setCod(UUID.randomUUID());
        userDTO.setDeleted(Boolean.FALSE);
        userDTO.setType(UserType.DEFAULT);

        User savedUser = repository.save(mapper.dtoToEntity(userDTO));

        UserConfigDTO userConfigDTO = userConfigService.createAndSaveDefaultUserConfig(mapper.entityToDto(savedUser));

        UserDTO savedUserDTO = mapper.entityToDto(savedUser);
        savedUserDTO.setUserConfigs(List.of(userConfigDTO));

        return savedUserDTO;
    }

    @Transactional
    public void validateExistsUserByEmail(String email) throws Exception {
        if(repository.existsUserByEmail(email)){
            throw new Exception("");
        }
    }
}
