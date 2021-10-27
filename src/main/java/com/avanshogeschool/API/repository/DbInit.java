package com.avanshogeschool.API.repository;

import com.avanshogeschool.API.domain.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DbInit {
    public DbInit(
            CarListingRepository carListingRepository,
            CarRepository carRepository,
            ReservationRepository reservationRepository,
            UserRepository userRepository
    ) {
        Car car = new Car("Mercedes", CarType.ELECTRIC, CarTransmission.AUTOMATIC, CarSize.BIG, "Breda");
        Car car1 = new Car("Lambo", CarType.GAS, CarTransmission.AUTOMATIC, CarSize.MEDIUM, "Tilburg");
        Car car2 = new Car("Volkswagen", CarType.DIESEL, CarTransmission.MANUAL, CarSize.BIG, "Amsterdam");
        carRepository.save(car);
        carRepository.save(car1);
        carRepository.save(car2);
        CarListing carListing = new CarListing(car, 4000, true, "test", 800, 0.15);
        carListingRepository.save(carListing);
        Customer customer = new Customer("Danny", "danny123", "abctest123");
        userRepository.save(customer);
        Reservation reservation = new Reservation(carListing, 1L, LocalDateTime.now(), LocalDateTime.now());
        reservationRepository.save(reservation);
    }
}
