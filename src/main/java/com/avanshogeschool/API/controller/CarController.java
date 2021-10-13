package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.Car;
import com.avanshogeschool.API.domain.CarListing;
import com.avanshogeschool.API.repository.CarListingRepository;
import com.avanshogeschool.API.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarRepository carRepository;
    private final CarListingRepository carListingRepository;

    public CarController(CarRepository carRepository, CarListingRepository carListingRepository) {
        this.carRepository = carRepository;
        this.carListingRepository = carListingRepository;
    }
    @GetMapping
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(
            @PathVariable int id) {
        return carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(
            @RequestBody Car newCar) {
        try {
            Car car = carRepository.save(newCar);
            return new ResponseEntity<>(car, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            System.out.println("Error during creation of" + newCar + e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable int id) {
        if(!carRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
