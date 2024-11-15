package com.example.HKT.controller;

import com.example.HKT.DTOs.UserDto;
import com.example.HKT.entity.UserEntity;
import com.example.HKT.exceptionHandler.UserNotFoundException;
import com.example.HKT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping
//    public UserDto createUser(@RequestBody UserDto user) {
//        return userService.saveUser(user);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?>  getUser(@PathVariable Integer id){
//        try {
//        UserDto user = userService.getUserByid(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//        } catch (UserNotFoundException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

}
