package com.avanshogeschool.API.repository;

import com.avanshogeschool.API.domain.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DbInit {
    public DbInit(
            CarListingRepository carListingRepository,
            CarRepository carRepository,
            ReservationRepository reservationRepository
    ) {
        Car car = new Car("Mercedes", CarType.ELECTRIC, CarTransmission.AUTOMATIC, CarSize.BIG);
        Car car1 = new Car("Lambo", CarType.PETROL, CarTransmission.AUTOMATIC, CarSize.MEDIUM);
        Car car2 = new Car("Volkswagen", CarType.DIESEL, CarTransmission.MANUAL, CarSize.BIG);
        carRepository.save(car);
        carRepository.save(car1);
        carRepository.save(car2);
        CarListing carListing = new CarListing(car, 4000, true, "test", 800, 0.15);
        carListingRepository.save(carListing);
        Customer customer = new Customer("Danny", "danny123", "abctest123");
        Reservation reservation = new Reservation(carListing, 1L, LocalDateTime.now(), LocalDateTime.now());
        reservationRepository.save(reservation);
    }
}
