package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.repository.CarListingRepository;
import com.avanshogeschool.API.domain.CarListing;
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
    public CarListing createCarListing(
            @RequestBody CarListing carListing) {
        carListingRepository.save(carListing);
        return carListing;
    }
}
