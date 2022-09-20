package com.programeiros.thisfinans.controllers;

import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.mappers.UserMapper;
import com.programeiros.thisfinans.services.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO) throws Exception {
        UserDTO newUser = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOneUser(@PathVariable(value = "id") Long id) throws NotFoundException {
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.accepted().body(userDTO);
    }
}
