package dev.fedosov.springcourse.Project3Boot.validators.measurement;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValueValidator implements ConstraintValidator<RangeValue, Double> {

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        return value >= -100 && value <= 100;
    }
}
