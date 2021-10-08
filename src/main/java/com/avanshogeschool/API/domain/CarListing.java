package com.avanshogeschool.API.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarListing {
    @Id
    @GeneratedValue
    private Long id;

    public CarListing() {

    }
}
