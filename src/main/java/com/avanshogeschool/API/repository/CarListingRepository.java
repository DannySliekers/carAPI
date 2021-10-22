package com.avanshogeschool.API.repository;

import com.avanshogeschool.API.domain.CarListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarListingRepository extends JpaRepository<CarListing, Long> {
}
