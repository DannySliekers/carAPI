package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.repository.CarListingRepository;
import com.avanshogeschool.API.domain.CarListing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carlisting")
public class CarListingController {

    private final CarListingRepository carListingRepository;

    public CarListingController(CarListingRepository carListingRepository) {
        this.carListingRepository = carListingRepository;
    }

    @GetMapping
    public Iterable<CarListing> getCarListing() {
        return carListingRepository.findAll();
    }
}
