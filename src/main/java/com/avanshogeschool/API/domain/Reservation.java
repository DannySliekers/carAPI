package com.avanshogeschool.API.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private CarListing carListing;

    private int userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Reservation(CarListing carListing, int userId, LocalDateTime startTime, LocalDateTime endTime) {
        this.carListing = carListing;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Reservation() {

    }

    public CarListing getCarListing() {
        return carListing;
    }

    public void setCarListing(CarListing carListing) {
        this.carListing = carListing;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
