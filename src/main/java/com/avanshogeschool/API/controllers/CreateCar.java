package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCar {

    @GetMapping("/createCar")
    public String createCar() {
        return "create car";
    }
}
