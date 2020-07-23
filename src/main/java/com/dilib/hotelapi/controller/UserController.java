package com.dilib.hotelapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{username}")
    public ResponseEntity<String> getUserByUsername(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok("Finding " + username);
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> addUserWithUsername(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok("Added " + username);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUserWithUsername(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok("Deleted " + username);
    }
}
