package com.avanshogeschool.API.domain;

public class Feedback {

    public String textField;
    public int rating;
    public String userName;

    public Feedback(){

    }

    public Feedback(String textField, int rating, String userName){
        super();
        this.textField = textField;
        this.rating = rating;
        this.userName = userName;
    }
}
