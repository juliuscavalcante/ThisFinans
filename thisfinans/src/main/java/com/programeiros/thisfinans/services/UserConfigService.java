package com.programeiros.thisfinans.services;

import com.programeiros.thisfinans.model.entities.UserConfig;
import com.programeiros.thisfinans.repositories.UserConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserConfigService {

    private final UserConfigRepository userConfigRepository;

    public UserConfigService(UserConfigRepository userConfigRepository) {
        this.userConfigRepository = userConfigRepository;
    }

    @Transactional
    public UserConfig save(UserConfig userConfig){
        return userConfigRepository.save(userConfig);
    }
}
