package dev.fedosov.springcourse.Project3Boot.controllers;

import dev.fedosov.springcourse.Project3Boot.dto.SensorDTO;
import dev.fedosov.springcourse.Project3Boot.models.Sensor;
import dev.fedosov.springcourse.Project3Boot.services.SensorsService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorsService sensorsService;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorsController(SensorsService sensorsService, ModelMapper modelMapper) {
        this.sensorsService = sensorsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<SensorDTO> registration(@RequestBody @Valid SensorDTO sensorDTO) {
        sensorsService.save(convertToSensor(sensorDTO));
        return new ResponseEntity<>(sensorDTO, HttpStatus.CREATED);
    }

    public Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
