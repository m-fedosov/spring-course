package dev.fedosov.springcourse.Project3Boot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {
    @NotEmpty(message = "name shouldn't be empty")
    private String name;
}
