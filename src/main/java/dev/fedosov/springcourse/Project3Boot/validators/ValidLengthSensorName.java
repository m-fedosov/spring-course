package dev.fedosov.springcourse.Project3Boot.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidLengthSensorNameValidator.class)
public @interface ValidLengthSensorName {
    String message() default "Sensor name should be between 3 and 30 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
