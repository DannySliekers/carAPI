package com.avanshogeschool.API.domain;

public class BookYourCar {

    private Long reservationId;
    private String carId;


    public BookYourCar(){

    }

    public BookYourCar(Long reservationId, String carId){
        this.reservationId = reservationId;
        this.carId = carId;
    }

    public Long getReservationId(){
        return reservationId;
    }


    public void setReservationId(Long reservationId){
        this.reservationId = reservationId;
    }

    public String getCarId(){
        return carId;
    }

    public void setCarId(String carId){
        this.carId = carId;
    }

}
