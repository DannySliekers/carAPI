package com.avanshogeschool.API.repository;

import com.avanshogeschool.API.domain.*;
import org.springframework.stereotype.Component;

@Component
public class DbInit {
    public DbInit(
            CarListingRepository carListingRepository,
            CarRepository carRepository
    ) {
    }
}
