package dev.fedosov.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Название должно быть от 2 до 100 символов")
    private String title;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Автор должен быть от 2 до 100 символов")
    private String author;

    private int year;

    private Person reservedBy;

    public Book() {}
}
