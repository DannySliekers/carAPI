package com.avanshogeschool.API.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;

    private String model;
    private CarType carType;
    private CarTransmission transmission;
    private CarSize carSize;
    private String location;

    public Car(String model, CarType carType, CarTransmission transmission, CarSize carSize, String location) {
        this.model = model;
        this.carType = carType;
        this.transmission = transmission;
        this.carSize = carSize;
        this.location = location;
    }

    public Car() {

    }

    public int getId() {
        return id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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


