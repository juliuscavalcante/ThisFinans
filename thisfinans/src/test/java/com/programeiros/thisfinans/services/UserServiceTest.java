package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.dto.UserConfigDTO;
import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.mappers.UserMapper;
import com.programeiros.thisfinans.repositories.UserRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Spy
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Mock
    private UserConfigService userConfigService;

    @Test
    void shouldSaveUserAndUserConfig() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .cod(UUID.randomUUID())
                .username("Bruno Silva")
                .password("123456")
                .email("bruno.silva@gmail.com")
                .build();

        User user = userMapper.dtoToEntity(userDTO);

        when(userRepository.existsUserByEmail(userDTO.getEmail())).thenReturn(Boolean.FALSE);
        when(userRepository.save(user)).thenReturn(user);
        when(userConfigService.createAndSaveDefaultUserConfig(userDTO)).thenReturn(UserConfigDTO.builder().build());

        userService.save(userDTO);

        verify(userRepository).save(userMapper.dtoToEntity(userDTO));
        verify(userConfigService).createAndSaveDefaultUserConfig(userDTO);
    }

}
