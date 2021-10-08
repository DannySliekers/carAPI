package com.avanshogeschool.API.repository;

import com.avanshogeschool.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
