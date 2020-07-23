package com.dilib.hotelapi.controller;

import com.dilib.hotelapi.domain.dto.UserDto;
import com.dilib.hotelapi.domain.transformer.UserTransformer;
import com.dilib.hotelapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> getAllUsers() {
        return ResponseEntity.ok(UserTransformer.transform(userService.getUsers()));
    }

    @PostMapping
    public void addUserWithUsername(@RequestBody UserDto userDto) {
        userService.saveUser(UserTransformer.transform(userDto));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok(UserTransformer.transform(userService.getUserByUsername(username)));
    }

    @DeleteMapping("/{username}")
    public void deleteUserWithUsername(@PathVariable(value = "username") String username) {
        userService.deleteUserWithUsername(username);
    }
}
