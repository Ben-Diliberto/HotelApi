package com.dilib.hotelapi.domain.transformer;

import com.dilib.hotelapi.domain.User;
import com.dilib.hotelapi.domain.dto.UserDto;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserTransformer {

    public static User transform(UserDto userDto) {
        return new User(userDto.getUsername(), userDto.getPassword());
    }

    public static UserDto transform(User user) {
        return new UserDto(user.getUsername(), user.getPassword());
    }

    public static Collection<UserDto> transform(Collection<User> users) {
        return users.stream().map(UserTransformer::transform).collect(Collectors.toList());
    }

}
