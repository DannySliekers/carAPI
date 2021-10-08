package com.avanshogeschool.API.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CarListing {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Car car;

    private double price;
    private boolean available;
    private String image;
    private int freeKm;
    private double pricePerExtraKm;

    public CarListing(Car car, double price, boolean available, String image, int freeKm, double pricePerExtraKm) {
        this.car = car;
        this.price = price;
        this.available = available;
        this.image = image;
        this.freeKm = freeKm;
        this.pricePerExtraKm = pricePerExtraKm;
    }

    public CarListing() {

    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFreeKm() {
        return freeKm;
    }

    public void setFreeKm(int freeKm) {
        this.freeKm = freeKm;
    }

    public double getPricePerExtraKm() {
        return pricePerExtraKm;
    }

    public void setPricePerExtraKm(double pricePerExtraKm) {
        this.pricePerExtraKm = pricePerExtraKm;
    }
}
