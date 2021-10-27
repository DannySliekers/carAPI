package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.Car;
import com.avanshogeschool.API.domain.CarListing;
import com.avanshogeschool.API.domain.Reservation;
import com.avanshogeschool.API.repository.CarListingRepository;
import com.avanshogeschool.API.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final CarListingRepository carListingRepository;

    public ReservationController(ReservationRepository reservationRepository,
                                 CarListingRepository carListingRepository) {
        this.reservationRepository = reservationRepository;
        this.carListingRepository = carListingRepository;
    }

    @GetMapping
    public Iterable<Reservation> getAll(){
       return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(
            @PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // We request the parameter carListingId, to search the corresponding carlisting and insert it into the Reservation
    @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @RequestParam Long carListingId,
            @RequestBody Reservation newReservation) {
        try {
            Optional<CarListing> carListing = carListingRepository.findById(carListingId);
            if (carListing.isPresent()) {
                newReservation.setCarListing(carListing.get());
            } else {
                return ResponseEntity.notFound().build();
            }
            Reservation reservation = reservationRepository.save(newReservation);
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            System.out.println("Error during creation of" + newReservation + e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReservation(@PathVariable Long id) {
        if(!reservationRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        reservationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // carListingId is a request parameter for the same reason as the PostMapping
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateCarListing(@PathVariable Long id,
                                                       @RequestParam Long carListingId,
                                                       @RequestBody Reservation newReservation) {
        Optional<Reservation> reservation = reservationRepository.findById(id);

        if (reservation.isPresent()) {
            Reservation oldReservation = reservation.get();
            Optional<CarListing> carListing = carListingRepository.findById(carListingId);
            if (carListing.isPresent()) {
                oldReservation.setCarListing(carListing.get());
            } else {
                return ResponseEntity.notFound().build();
            }
            oldReservation.setUserId(newReservation.getUserId());
            oldReservation.setStartTime(newReservation.getStartTime());
            oldReservation.setEndTime(newReservation.getEndTime());
            return ResponseEntity.ok(reservationRepository.save(oldReservation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
