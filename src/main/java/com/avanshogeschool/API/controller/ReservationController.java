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
}
