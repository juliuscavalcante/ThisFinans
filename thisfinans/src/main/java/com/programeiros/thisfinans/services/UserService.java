package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.UserConfigDTO;
import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.mappers.UserMapper;
import com.programeiros.thisfinans.repositories.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserConfigService userConfigService;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) throws NotFoundException {
        User user = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.entityToDto(user);
    }

    @Transactional
    public UserDTO save(UserDTO userDTO) throws Exception {
        validateExistsUserByEmail(userDTO.getEmail());

        User savedUser = repository.save(mapper.dtoToEntity(userDTO));

        UserConfigDTO userConfigDTO = userConfigService.createAndSaveDefaultUserConfig(mapper.entityToDto(savedUser));

        UserDTO savedUserDTO = mapper.entityToDto(savedUser);
        savedUserDTO.setUserConfigs(List.of(userConfigDTO));

        return savedUserDTO;
    }

    private void validateExistsUserByEmail(String email) throws Exception {
        if(repository.existsUserByEmail(email)){
            throw new Exception("");
        }
    }
}
