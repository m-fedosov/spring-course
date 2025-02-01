package dev.fedosov.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "title")
    @Size(min = 2, max = 100, message = "Название должно быть от 2 до 100 символов")
    private String title;

    @NotEmpty
    @Column(name = "author")
    @Size(min = 2, max = 100, message = "Автор должен быть от 2 до 100 символов")
    private String author;

    @Column(name = "year")
    private int year;

    @Column(name = "reserved_by")
    private Integer reservedBy;

    @Column(name = "reserved_time")
    private Timestamp reservedTime;

    public Book() {}
}
