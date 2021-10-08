package com.avanshogeschool.API.repository;

import com.avanshogeschool.API.domain.CarListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarListingRepository extends JpaRepository<CarListing, Integer> {
}
