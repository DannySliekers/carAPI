package com.avanshogeschool.API.domain;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reservation {

    public String id;
    public String userId;
    public String bill;
    public String status;
    public String driver;
    public Date startDate;
    public Time startTime;
    public Date endDate;
    public Time endTime;

    private Set<BookYourCar> bookYourCar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<BookYourCar> getBookCar() {
        return bookYourCar;
    }

    public void setBookCar(Set<BookYourCar> bookYourCar) {
        this.bookYourCar = bookYourCar;
    }

    public void addBookCar(BookYourCar bookYourCar){
        if (this.bookYourCar == null){
            this.bookYourCar = new HashSet<>();
        }
        this.bookYourCar.add(bookYourCar);
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}
