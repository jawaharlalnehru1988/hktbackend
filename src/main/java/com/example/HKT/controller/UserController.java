package com.example.HKT.controller;

import com.example.HKT.DTOs.UserDto;
import com.example.HKT.entity.UserEntity;
import com.example.HKT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id){
        return userService.getUserByid(id);
    }
}
