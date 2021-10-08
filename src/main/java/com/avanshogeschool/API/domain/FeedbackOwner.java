package com.avanshogeschool.API.domain;

public class FeedbackOwner {

    public String textField;
    public int rating;
    public String userName;

    public FeedbackOwner(){

    }

    public FeedbackOwner(String textField, int rating, String userName){
        super();
        this.textField = textField;
        this.rating = rating;
        this.userName = userName;
    }
}
