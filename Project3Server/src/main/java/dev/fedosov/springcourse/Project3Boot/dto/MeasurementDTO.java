package dev.fedosov.springcourse.Project3Boot.dto;

import dev.fedosov.springcourse.Project3Boot.validators.measurement.ExistsSensor;
import dev.fedosov.springcourse.Project3Boot.validators.measurement.RangeValue;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementDTO {
    @NotNull(message = "value shouldn't be empty")
    @RangeValue
    private Double value;
    @NotNull(message = "raining shouldn't be empty")
    private Boolean raining;
    @ExistsSensor
    private SensorDTO sensor;
}
