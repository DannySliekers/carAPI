package com.avanshogeschool.API.service;

import com.avanshogeschool.API.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
    }

    // Hashes the password the user chose
    public String hashPassword(String password) {
        return this.bCryptPasswordEncoder.encode(password);
    }

    // checks if password entered is same as hashed password in database
    public boolean matchHashedPassword(String password, User user) {
        return this.bCryptPasswordEncoder.matches(password, user.getHash());
    }
}
