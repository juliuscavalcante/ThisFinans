package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.DB.DBException;
import com.programeiros.thisfinans.model.dto.UserDTO;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    public boolean existsUserByEmail(String email) {
        return repository.existsUserByEmail(email);
    }




}
