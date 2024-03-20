package com.primarchan.userservice.service;

import com.primarchan.userservice.dto.UserDto;
import com.primarchan.userservice.entity.UserEntity;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();

}
