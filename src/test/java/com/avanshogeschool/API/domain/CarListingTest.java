package com.avanshogeschool.API.domain;

import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertNull;

public class CarListingTest {
    @Test
    void getCar_expectNULL() {
        CarListing carListing = new CarListing(5, true, "test", 5, 5);

        Car car = carListing.getCar();

        assertNull("test", car);
    }

    @Test
    void getCar_expectNotNull() {
        Car car = new Car("Volkswagen", CarType.HYDROGEN, CarTransmission.AUTOMATIC, CarSize.BIG);
        CarListing carListing = new CarListing(car, 5, true, "test", 5, 5);

        Car carListingCar = carListing.getCar();

        assertNotNull("test", carListingCar);
    }
}
