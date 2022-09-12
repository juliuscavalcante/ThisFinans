package com.programeiros.thisfinans.controller;

import com.programeiros.thisfinans.model.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

//    @GetMapping
//    public ResponseEntity<User> findAllUsers(){
////        User u = new User(1L, "Teste", "teste", "teste", "teste", null);
////        return ResponseEntity.ok().body(u);
//    }
}
