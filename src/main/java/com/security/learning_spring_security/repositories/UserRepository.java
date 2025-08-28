package com.security.learning_spring_security.repositories;

import com.security.learning_spring_security.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    boolean existsByUsername(String userName);

    Optional<UserEntity> findByUsername(String userName);
}
