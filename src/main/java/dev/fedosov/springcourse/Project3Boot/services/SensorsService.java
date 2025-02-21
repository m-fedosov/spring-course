package dev.fedosov.springcourse.Project3Boot.services;

import dev.fedosov.springcourse.Project3Boot.models.Sensor;
import dev.fedosov.springcourse.Project3Boot.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void save(Sensor sensor) {
        enrichSensor(sensor);
        sensorsRepository.save(sensor);
    }

    private void enrichSensor(Sensor sensor) {
        sensor.setCreatedBy("ADMIN");
    }
}
