package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.entities.UserConfig;
import com.programeiros.thisfinans.model.enums.UserType;
import com.programeiros.thisfinans.services.UserConfigService;
import com.programeiros.thisfinans.services.UserService;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserConfigService userConfigService;



    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO){
        if(userService.existsUserByEmail(userDTO.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: email is already in use!");
        }

        User user   = new User();

        user.setCod(UUID.randomUUID());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setType(UserType.DEFAULT);
        user.setDeleted(false);
        user.setCreateDate(Instant.now());
        user.setUpdateDate(Instant.now());
        user.setUserConfigs(createdUserConfigDefault(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") Long id){
        Optional<User> userOptional = userService.findById(id);
        return userOptional.<ResponseEntity<Object>>map(user -> ResponseEntity.status(HttpStatus.OK).body(user)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }


    private UserConfig createdUserConfigDefault(User user){
        UserConfig userConfig = new UserConfig();
        userConfig.setBudgetClosingDay(5);
        userConfig.setCreateDate(Instant.now());
        userConfig.setUpdateDate(Instant.now());
        userConfig.setUser(user);
        return userConfigService.save(userConfig);
    }



}
