package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCarListing {
    @GetMapping("/getCarListing")
    public String getCarListing() {
        return "get car listing";
    }
}
