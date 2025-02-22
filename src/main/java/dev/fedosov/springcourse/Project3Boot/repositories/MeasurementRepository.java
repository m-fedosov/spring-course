package dev.fedosov.springcourse.Project3Boot.repositories;

import dev.fedosov.springcourse.Project3Boot.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    Integer countAllByRaining(Boolean raining);
}
