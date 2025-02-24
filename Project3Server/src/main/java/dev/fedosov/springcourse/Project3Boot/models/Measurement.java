package dev.fedosov.springcourse.Project3Boot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "raining", nullable = false)
    private Boolean raining = false;

    @Column(name = "measure_time", nullable = false)
    private LocalDateTime measureTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensor", nullable = false)
    private Sensor sensor;

}
