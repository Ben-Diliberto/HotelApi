package com.dilib.hotelapi.service;

import com.dilib.hotelapi.domain.User;
import com.dilib.hotelapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getUserByUsername(String username) {
       return userRepository.getUserByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(new User(user.getUsername(), user.getPassword()));
    }

    public void deleteUserWithUsername(String username) {
        userRepository.deleteById(username);
    }

}
