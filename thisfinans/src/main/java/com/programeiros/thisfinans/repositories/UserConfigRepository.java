package com.programeiros.thisfinans.repositories;

import com.programeiros.thisfinans.model.entities.UserConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfigRepository extends JpaRepository<UserConfig, Long> {
}
