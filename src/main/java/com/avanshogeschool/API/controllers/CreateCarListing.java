package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCarListing {
    @GetMapping("/createCarListing")
    public String createCarListing() {
        return "create car listing";
    }
}
