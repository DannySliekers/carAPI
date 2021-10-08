package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.repository.CarListingRepository;
import com.avanshogeschool.API.domain.CarListing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carlisting")
public class CarListingController {

    private final CarListingRepository carListingRepository;

    public CarListingController(CarListingRepository carListingRepository) {
        this.carListingRepository = carListingRepository;
    }

    @GetMapping
    public Iterable<CarListing> getAll() {
        return carListingRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<CarListing> createCarListing(
            @RequestBody CarListing carListing) {
        System.out.println(carListing.getCar().toString());
        return carListingRepository.save(carListing);
    }
}
