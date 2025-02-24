package dev.fedosov.springcourse.Project3Boot.repositories;

import dev.fedosov.springcourse.Project3Boot.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String sensorName);
}
