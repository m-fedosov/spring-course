package dev.fedosov.springcourse.Project3Boot.validators.measurement;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangeValueValidator.class)
public @interface RangeValue {
    String message() default "measurement value should be between -100 and 100";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
