package com.security.learning_spring_security.repositories;

import com.security.learning_spring_security.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(String name);
}
