package com.example.HKT.controller;

import com.example.HKT.entity.Fruits;
import com.example.HKT.repository.FruitsRepository;
import com.example.HKT.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fruits")
public class fruitsController {
@Autowired
private FruitsService fruitsService;
    @GetMapping()
    public List<Fruits> getAllFruits(){
        return fruitsService.getAllFruits();
    }
}
