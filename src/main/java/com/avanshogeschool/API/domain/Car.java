package com.avanshogeschool.API.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private CarListing carListing;

    private String model;
    private CarType carType;
    private CarTransmission transmission;
    private CarSize carSize;

    public Car(String model, CarType carType, CarTransmission transmission, CarSize carSize) {
        this.model = model;
        this.carType = carType;
        this.transmission = transmission;
        this.carSize = carSize;
    }

    public Car() {

    }

    public CarSize getCarSize() {
        return carSize;
    }

    public void setCarSize(CarSize carSize) {
        this.carSize = carSize;
    }

    public CarTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(CarTransmission transmission) {
        this.transmission = transmission;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", carType=" + carType +
                ", transmission=" + transmission +
                ", carSize=" + carSize +
                '}';
    }
}


