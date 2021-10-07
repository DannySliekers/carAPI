package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCar {
    @GetMapping("/getCar")
    public String getCar() {
        return "get car";
    }
}
