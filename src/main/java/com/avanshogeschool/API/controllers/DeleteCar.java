package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCar {
    @GetMapping("/deleteCar")
    public String deleteCar() {
        return "delete car";
    }
}
