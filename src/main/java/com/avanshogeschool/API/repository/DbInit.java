package com.avanshogeschool.API.repository;

import com.avanshogeschool.API.domain.Car;
import com.avanshogeschool.API.domain.CarListing;
import com.avanshogeschool.API.domain.CarSize;
import com.avanshogeschool.API.domain.CarType;
import org.springframework.stereotype.Component;

@Component
public class DbInit {
    public DbInit(
            CarListingRepository carListingRepository,
            CarRepository carRepository
    ) {
        Car car = new Car("Mercedes", CarType.ELECTRIC, "automaat", CarSize.BIG);
        carRepository.save(car);
        CarListing carListing = new CarListing(car, 4000, true, "test", 800, 0.15);
        carListingRepository.save(carListing);
    }
}
