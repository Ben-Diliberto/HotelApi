package com.dilib.hotelapi.service;

import com.dilib.hotelapi.domain.User;
import com.dilib.hotelapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Collection<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getUserByUsername(String username) {
       return userRepository.getUserByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword())));
    }

    public void deleteUserWithUsername(String username) {
        userRepository.deleteById(username);
    }

    public boolean exists(String username) {
        return userRepository.existsById(username);
    }

}
