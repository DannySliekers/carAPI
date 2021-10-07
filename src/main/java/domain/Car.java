package domain;

import java.io.Serializable;

public class Car implements Serializable {

    public static String id;
    public static String constructionYear;
    public static String transmission;
    public static String fuel;
    public static String pricePer; /** price per: kilometer, liter fuel, day, hour, etc.**/
    public static int price;
    private static String model;


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



}


