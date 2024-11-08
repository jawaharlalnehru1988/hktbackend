package com.example.HKT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/array")
public class ArrayManipulationController {
    @GetMapping("/sum")
    public int getSum(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int number : numbers){
            if(number % 2 == 0){
                sum += number;
            }
        }
        return sum;

    }
}
