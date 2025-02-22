package dev.fedosov.springcourse.Project3Boot.validators.measurement;

import dev.fedosov.springcourse.Project3Boot.dto.SensorDTO;
import dev.fedosov.springcourse.Project3Boot.services.SensorsService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistsSensorValidator implements ConstraintValidator<ExistsSensor, SensorDTO> {

    private final SensorsService sensorsService;

    @Autowired
    public ExistsSensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }


    @Override
    public boolean isValid(SensorDTO sensorDTO, ConstraintValidatorContext constraintValidatorContext) {
        return sensorsService.findByName(sensorDTO.getName()).isPresent();
    }
}
