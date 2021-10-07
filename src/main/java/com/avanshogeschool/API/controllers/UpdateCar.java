package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCar {
    @GetMapping("updateCar")
    public String updateCar() {
        return "update car";
    }
}
