package com.avanshogeschool.API.domain;

import javax.persistence.Entity;

@Entity
public class Customer extends User{

    public Customer(String name, String username, String hash) {
        super(name, username, hash);
    }

    public Customer() {

    }
}
