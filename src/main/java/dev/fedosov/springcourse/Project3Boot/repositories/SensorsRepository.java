package dev.fedosov.springcourse.Project3Boot.repositories;

import dev.fedosov.springcourse.Project3Boot.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
}
