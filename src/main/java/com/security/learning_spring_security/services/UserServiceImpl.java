package com.security.learning_spring_security.services;

import com.security.learning_spring_security.entities.RoleEntity;
import com.security.learning_spring_security.entities.UserEntity;
import com.security.learning_spring_security.repositories.RoleRepository;
import com.security.learning_spring_security.repositories.UserRepository;
import com.security.learning_spring_security.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity user) {
        Optional<RoleEntity> role = roleRepository.findByName(Constants.ROLE_USER);
        Set<RoleEntity> roles = new HashSet<>();
        role.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<RoleEntity> optionalAdmin = roleRepository.findByName(Constants.ROLE_ADMIN);
            optionalAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }
}
