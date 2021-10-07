package com.avanshogeschool.API.domain;

import java.io.Serializable;

public class Car implements Serializable {

    public static String id;
    public static String model;
    public static String constructionYear;
    public static String transmission;
    public static String fuel;
    public static String pricePer; /** price per: kilometer, liter fuel, day, hour, etc.**/
    public static int price;

    public  boolean petsAllowed;
    public boolean smokingAllowed;
    public boolean isofixPresent;

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public boolean isSmokingAllowed() {
        return smokingAllowed;
    }

    public boolean isIsofixPresent() {
        return isofixPresent;
    }

    public Car(){

    }

    public Car(String model, String constructionYear, String transmission, String fuel, String pricePer, int price) {
        this.model = model;
        this.constructionYear = constructionYear;
        this.transmission = transmission;
        this.fuel = fuel;
        this.pricePer = pricePer;
        this.price = price;

        this.petsAllowed = isPetsAllowed();
        this.smokingAllowed = isSmokingAllowed();
        this.isofixPresent = isIsofixPresent();
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(String constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getPricePer() {
        return pricePer;
    }

    public void setPricePer(String pricePer) {
        this.pricePer = pricePer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Car [id=" + id + ", model=" + model + ", construction year=" + constructionYear + ", transmission=" + transmission + ", fuel=" + fuel
                +  " cost " + price + "per " + pricePer + "]";
    }
}


