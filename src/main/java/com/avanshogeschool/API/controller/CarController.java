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

    //bug: can't delete car if its tied to a carlisting
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable int id,
                                                @RequestParam Long carListingId) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carListingRepository.deleteById(carListingId);
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id,
                                         @RequestBody Car newCar) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car oldCar = optionalCar.get();
            oldCar.setModel(newCar.getModel());
            oldCar.setCarType(newCar.getCarType());
            oldCar.setTransmission(newCar.getTransmission());
            oldCar.setCarSize(newCar.getCarSize());
            return ResponseEntity.ok(carRepository.save(oldCar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
