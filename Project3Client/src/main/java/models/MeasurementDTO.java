package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementDTO {
    private Double value;
    private Boolean raining;
    private SensorDTO sensor;
}