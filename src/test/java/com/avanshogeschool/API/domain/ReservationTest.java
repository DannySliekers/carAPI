package com.avanshogeschool.API.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertNull;

public class ReservationTest {

    @Test
    void getCarListing_expectNull() {
        Reservation reservation = new Reservation(5L, LocalDateTime.now(), LocalDateTime.now());

        CarListing carListing = reservation.getCarListing();

        assertNull("test", carListing);
    }

    @Test
    void getCarListing_expectNotNull() {
        CarListing carListing = new CarListing(5, true, "", 5, 5);
        Reservation reservation = new Reservation(carListing,5L, LocalDateTime.now(), LocalDateTime.now());

        CarListing reservationCarListing = reservation.getCarListing();

        assertNotNull("carListing", reservationCarListing);
    }
}
