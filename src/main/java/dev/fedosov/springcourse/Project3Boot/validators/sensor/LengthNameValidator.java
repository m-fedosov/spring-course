package dev.fedosov.springcourse.Project3Boot.validators.sensor;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class LengthNameValidator implements ConstraintValidator<LengthName, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return name.length() >= 3 && name.length() <= 30;
    }
}
