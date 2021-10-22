package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.Car;
import com.avanshogeschool.API.domain.CarListing;
import com.avanshogeschool.API.domain.Reservation;
import com.avanshogeschool.API.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
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

 /*   @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @RequestBody Reservation newReservation) {
        try {
            Reservation reservation = reservationRepository.save(newReservation);
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            System.out.println("Error during creation of" + newReservation + e);
            return ResponseEntity.badRequest().build();
        }
    }*/
}
