package dev.fedosov.springcourse.Project3Boot.controllers;

import dev.fedosov.springcourse.Project3Boot.dto.SensorDTO;
import dev.fedosov.springcourse.Project3Boot.models.Sensor;
import dev.fedosov.springcourse.Project3Boot.services.SensorsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorsService sensorsService;

    @Autowired
    public SensorsController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @PostMapping("/registration")
    public ResponseEntity<SensorDTO> registration(@RequestBody @Valid SensorDTO sensorDTO) {
        sensorsService.save(convertToSensor(sensorDTO));
        return new ResponseEntity<>(sensorDTO, HttpStatus.CREATED);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.getName());
        sensor.setCreatedAt(LocalDateTime.now());
        return sensor;
    }
}
