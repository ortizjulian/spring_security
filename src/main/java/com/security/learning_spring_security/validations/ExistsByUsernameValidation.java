package com.security.learning_spring_security.validations;

import com.security.learning_spring_security.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername,String> {

    private UserService service;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return !service.existsByUsername(userName);
    }
}
