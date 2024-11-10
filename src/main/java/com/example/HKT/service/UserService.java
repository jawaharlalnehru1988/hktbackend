package com.example.HKT.service;

import com.example.HKT.DTOs.UserDto;
import com.example.HKT.entity.UserEntity;

public interface UserService {
    public UserDto saveUser(UserDto userDto);
    public UserDto getUserByid(Long id);
}
