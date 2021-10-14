package com.avanshogeschool.API.domain;

import javax.persistence.Entity;

@Entity
public class Employee extends User{

    public Employee(String name, String username, String hash) {
        super(name, username, hash);
    }

    public Employee() {

    }
}
