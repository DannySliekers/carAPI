package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCarListing {
    @GetMapping("/updateCarListing")
    public String updateCarListing() {
        return "update car listing";
    }
}
