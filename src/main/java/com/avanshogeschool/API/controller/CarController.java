package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.Car;
import com.avanshogeschool.API.domain.CarSize;
import com.avanshogeschool.API.domain.CarType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    @GetMapping
    public String getCar() {
        return new Car("Mercedes a180", CarType.GASOLINE, "handgeschakeld", CarSize.SMALL).toString();
    }
}
