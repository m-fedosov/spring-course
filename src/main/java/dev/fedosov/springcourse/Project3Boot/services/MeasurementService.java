package dev.fedosov.springcourse.Project3Boot.services;

import dev.fedosov.springcourse.Project3Boot.models.Measurement;
import dev.fedosov.springcourse.Project3Boot.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorsService sensorsService) {
        this.measurementRepository = measurementRepository;
        this.sensorsService = sensorsService;
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setMeasureTime(LocalDateTime.now());
        measurement.setSensor(sensorsService.findByName(measurement.getSensor().getName()).get());
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }
}
