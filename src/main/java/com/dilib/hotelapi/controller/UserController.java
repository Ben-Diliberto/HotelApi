package com.dilib.hotelapi.controller;

import com.dilib.hotelapi.domain.User;
import com.dilib.hotelapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping("/{username}")
    public void addUserWithUsername(@PathVariable(value = "username") String username) {
        userService.saveUser(username);
    }

    @DeleteMapping("/{username}")
    public void deleteUserWithUsername(@PathVariable(value = "username") String username) {
        userService.deleteUserWithUsername(username);
    }
}
