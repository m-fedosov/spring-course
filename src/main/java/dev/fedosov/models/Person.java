package dev.fedosov.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;

    @NotEmpty
    @Size(min = 2, max = 50, message = "ФИО должно быть от 2 до 50 символов")
    private String fullName;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private int birthYear;
}
