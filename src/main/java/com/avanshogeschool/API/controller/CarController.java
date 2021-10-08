package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.Car;
import com.avanshogeschool.API.domain.CarSize;
import com.avanshogeschool.API.domain.CarTransmission;
import com.avanshogeschool.API.domain.CarType;
import com.avanshogeschool.API.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @GetMapping
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }
}
