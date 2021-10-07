package com.avanshogeschool.API.domain;

public class FeedbackCar {
    public String textField;
    public int rating;
    public String carId;
    public String model;
    public String constructionYear;
    public String transmission;
    public String fuel;

    public FeedbackCar(){

    }

    public FeedbackCar(String textField, int rating, String carId){
        super();
        this.textField = textField;
        this.rating = rating;
        this.carId = carId;
    }
}
