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
    private String transmission;
    private CarSize carSize;

    public Car(String model, CarType carType, String transmission, CarSize carSize) {
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

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
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
        return "Car{" + "id='" + id + '\'' +
                " model='" + model + '\'' +
                ", carType=" + carType +
                '}';
    }
}


