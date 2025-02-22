package dev.fedosov.springcourse.Project3Boot.dto;

import dev.fedosov.springcourse.Project3Boot.validators.sensor.UniqueName;
import dev.fedosov.springcourse.Project3Boot.validators.sensor.LengthName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {
    @UniqueName
    @LengthName
    private String name;
}
