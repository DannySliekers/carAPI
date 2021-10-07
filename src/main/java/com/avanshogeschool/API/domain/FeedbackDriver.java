package com.avanshogeschool.API.domain;

public class FeedbackDriver {

    public String textField;
    public int rating;
    public String userName;

    public FeedbackDriver(){

    }

    public FeedbackDriver(String textField, int rating, String userName){
        super();
        this.textField = textField;
        this.rating = rating;
        this.userName = userName;
    }
}
