package dev.fedosov.springcourse.Project3Boot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Size(max = 30)
    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @OneToMany(mappedBy = "sensor")
    private Set<Measurement> measurements = new HashSet<>();

}
