package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.Car;
import com.avanshogeschool.API.repository.CarListingRepository;
import com.avanshogeschool.API.domain.CarListing;
import com.avanshogeschool.API.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carlisting")
public class CarListingController {

    private final CarListingRepository carListingRepository;
    private final CarRepository carRepository;

    public CarListingController(CarListingRepository carListingRepository,
                                CarRepository carRepository) {
        this.carListingRepository = carListingRepository;
        this.carRepository = carRepository;
    }

    @GetMapping
    public Iterable<CarListing> getAll() {
        return carListingRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<CarListing> createCarListing(
            @RequestParam int carId,
            @RequestBody CarListing newCarListing) {
        try {
            Optional<Car> car = carRepository.findById(carId);
            newCarListing.setCar(car.get());
            CarListing carListing = carListingRepository.save(newCarListing);
            return new ResponseEntity<>(carListing, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            System.out.println("Error during creation of" + newCarListing + e);
            return ResponseEntity.badRequest().build();
        }
    }
}
