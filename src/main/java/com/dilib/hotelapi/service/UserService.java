package com.dilib.hotelapi.service;

import com.dilib.hotelapi.domain.User;
import com.dilib.hotelapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
       return userRepository.getUserByUsername(username);
    }

    public void saveUser(String username) {
        userRepository.save(new User(username, "passw0rd"));
    }

}
