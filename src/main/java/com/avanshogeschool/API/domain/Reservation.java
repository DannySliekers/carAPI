package com.avanshogeschool.API.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CarListing carListing;

    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Reservation(CarListing carListing, Long userId, LocalDateTime startTime, LocalDateTime endTime) {
        this.carListing = carListing;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Reservation(Long userId, LocalDateTime startTime, LocalDateTime endTime) {
        this.carListing = carListing;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Reservation() {

    }

    public Long getId() {
        return id;
    }

    public CarListing getCarListing() {
        return carListing;
    }

    public void setCarListing(CarListing carListing) {
        this.carListing = carListing;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
