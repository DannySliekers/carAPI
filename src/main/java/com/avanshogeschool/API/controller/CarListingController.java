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

    @GetMapping("/{id}")
    public ResponseEntity<CarListing> getById(
            @PathVariable Long id) {
        return carListingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // we request the parameter carId, and with that carId we search the corresponding car, and insert that into the carlisting
    @PostMapping
    public ResponseEntity<CarListing> createCarListing(
            @RequestParam int carId,
            @RequestBody CarListing newCarListing) {
        try {
            Optional<Car> car = carRepository.findById(carId);
            if (car.isPresent()) {
                newCarListing.setCar(car.get());
            } else {
                return ResponseEntity.notFound().build();
            }
            CarListing carListing = carListingRepository.save(newCarListing);
            return new ResponseEntity<>(carListing, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            System.out.println("Error during creation of" + newCarListing + e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCarListing(@PathVariable Long id) {
        if(!carListingRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        carListingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // test comment
    // carId is a request parameter for the same reason as the PostMapping
    @PutMapping("/{id}")
    public ResponseEntity<CarListing> updateCarListing(@PathVariable Long id,
                                                       @RequestParam int carId,
                                                       @RequestBody CarListing newCarListing) {
        Optional<CarListing> carListing = carListingRepository.findById(id);

        if (carListing.isPresent()) {
            CarListing oldCarListing = carListing.get();
            Optional<Car> car = carRepository.findById(carId);
            if (car.isPresent()) {
                oldCarListing.setCar(car.get());
            } else {
                return ResponseEntity.notFound().build();
            }
            oldCarListing.setPrice(newCarListing.getPrice());
            oldCarListing.setAvailable(newCarListing.isAvailable());
            oldCarListing.setImage(newCarListing.getImage());
            oldCarListing.setFreeKm(newCarListing.getFreeKm());
            oldCarListing.setPricePerExtraKm(newCarListing.getPricePerExtraKm());
            return ResponseEntity.ok(carListingRepository.save(oldCarListing));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
