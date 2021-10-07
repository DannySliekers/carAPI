package com.avanshogeschool.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCarListing {
    @GetMapping("/deleteCarListing")
    public String deleteCarListing() {
        return "Delete car listing";
    }
}
