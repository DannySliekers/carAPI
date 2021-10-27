package com.avanshogeschool.API.service;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserServiceTest {
    @Test
    void hashPassword_expectNotSameAsPasswordInserted() {
        UserService userService = new UserService();
        String mockPassword = "test123";

        String hashedPassword = userService.hashPassword(mockPassword);

        assertFalse(mockPassword.equals(hashedPassword));
    }
}
