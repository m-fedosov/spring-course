package dev.fedosov.springcourse.Project3Boot.validators;

import dev.fedosov.springcourse.Project3Boot.services.SensorsService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueSensorNameValidator implements ConstraintValidator<UniqueSensorName, String> {
    private final SensorsService sensorsService;

    @Autowired
    public UniqueSensorNameValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return sensorsService.findByName(name).isEmpty();
    }
}
