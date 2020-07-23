package com.dilib.hotelapi.repository;

import com.dilib.hotelapi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User getUserByUsername(String username);
}
