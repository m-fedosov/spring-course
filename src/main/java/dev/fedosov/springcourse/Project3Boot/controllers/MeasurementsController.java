package dev.fedosov.springcourse.Project3Boot.controllers;

import dev.fedosov.springcourse.Project3Boot.dto.MeasurementDTO;
import dev.fedosov.springcourse.Project3Boot.models.Measurement;
import dev.fedosov.springcourse.Project3Boot.services.MeasurementService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementsController(MeasurementService measurementService, ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<MeasurementDTO>> getAllMeasurements() {
        List<MeasurementDTO> measurementDTOList = measurementService.findAll().stream().map(m -> modelMapper.map(m, MeasurementDTO.class)).toList();
        return new ResponseEntity<>(measurementDTOList, HttpStatus.CREATED);
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Integer> getRainyDaysCount() {
        return new ResponseEntity<>(measurementService.countRainyDays(), HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<MeasurementDTO> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO) {
        measurementService.save(convertToMeasurement(measurementDTO));
        return new ResponseEntity<>(measurementDTO, HttpStatus.CREATED);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }
}
