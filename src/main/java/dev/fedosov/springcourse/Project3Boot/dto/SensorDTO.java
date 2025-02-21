package dev.fedosov.springcourse.Project3Boot.dto;

import dev.fedosov.springcourse.Project3Boot.validators.UniqueSensorName;
import dev.fedosov.springcourse.Project3Boot.validators.ValidLengthSensorName;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {
    @NotEmpty(message = "name shouldn't be empty")
    @UniqueSensorName
    @ValidLengthSensorName
    private String name;
}
