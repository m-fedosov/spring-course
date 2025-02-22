package dev.fedosov.springcourse.Project3Boot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementDTO {
    private Double value;
    private Boolean raining;
    private SensorDTO sensor;
}
