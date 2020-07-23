package com.dilib.hotelapi.domain.transformer;

import com.dilib.hotelapi.domain.User;
import com.dilib.hotelapi.domain.dto.UserDto;

public class UserTransformer {

    public static User transform(UserDto userDto) {
        return new User(userDto.getUsername(), userDto.getPassword());
    }

    public static UserDto transform(User user) {
        return new UserDto(user.getUsername(), user.getPassword());
    }

}
