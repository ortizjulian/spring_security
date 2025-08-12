package com.security.learning_spring_security.services;

import com.security.learning_spring_security.entities.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();
    UserEntity save(UserEntity userEntity);

}
