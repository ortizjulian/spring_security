package com.security.learning_spring_security.repositories;

import com.security.learning_spring_security.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity,Long> {
}
