package domain;

import java.io.Serializable;

public class Car implements Serializable {

    public static final String ATTRIBUTE_ID = "id";
    public static final String ATTRIBUTE_MODEL = "model";
    public static final String ATTRIBUTE_CONSTRUCTION_YEAR = "construction_year";
    public static final String ATTRIBUTE_TRANSMISSION = "transmission";
    public static final String ATTRIBUTE_FUEL = "fuel";
    public static final String ATTRIBUTE_PRICE_PER = "price_per"; /** price per: kilometer, liter fuel, day, hour, etc.**/
    public static final String ATTRIBUTE_price = "price";

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


