package com.example.HKT.controller;

import com.example.HKT.DTOs.PeopleDTO;
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

    @GetMapping("/average")
    public double calculateAverageAge(){
        PeopleDTO[] people = {
                new PeopleDTO("Hare", 12),
                new PeopleDTO("Krishna", 34),
                new PeopleDTO("Ram", 32)
        };

        int sum = 0;
        for (PeopleDTO person: people){
            sum += person.getAge();
        }

        return (double) sum / people.length;
    }

}
