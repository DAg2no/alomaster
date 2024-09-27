package com.principal.alomaster.validators;

import com.principal.alomaster.annotations.PasswordMatches;
import com.principal.alomaster.models.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {


    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        // No-op
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        User user = (User) value;
        return user.getPassword().equals(user.getPasswordConfirm());
    }
}