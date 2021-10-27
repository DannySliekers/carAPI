package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.Reservation;
import com.avanshogeschool.API.domain.User;
import com.avanshogeschool.API.repository.UserRepository;
import com.avanshogeschool.API.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository,
                          UserService userService
    ) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(
            @PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //mapped to /username/{username} because otherwise it would collide with getById
    @GetMapping("/username/{userName}")
    public ResponseEntity<User> getByUserName(
            @PathVariable String userName) {
        return userRepository.findByUserName(userName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            newUser.setHash(userService.hashPassword(newUser.getHash()));
            User user = userRepository.save(newUser);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch(IllegalArgumentException e) {
            System.out.println("Error during creation of" + newUser + e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        if(!userRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                         @RequestBody User newUser
    ) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User oldUser = optionalUser.get();
            oldUser.setName(newUser.getName());
            oldUser.setUsername(newUser.getUsername());
            oldUser.setHash(newUser.getHash());
            return ResponseEntity.ok(userRepository.save(oldUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
