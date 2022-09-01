package com.programeiros.thisfinans.controller;

import com.programeiros.thisfinans.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
