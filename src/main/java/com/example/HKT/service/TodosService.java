package com.example.HKT.service;

import com.example.HKT.DTOs.NumberObject;
import org.springframework.stereotype.Service;

@Service
public class TodosService {
    public String getKrishnaMessage(){
        return "Hare Krishna! All glories to srila prabhupada";
    }

    public int getNumber(){
        return 16;
    }

    public int[] getNumbersArray(){
        return new int[]{1, 2, 3, 4, 5};
    }

    public NumberObject[] getNumberObjectsArray(){
        NumberObject[] numberObjects = new NumberObject[]{
                new NumberObject(1, 10),
                new NumberObject(2, 20),
                new NumberObject(3, 30),
                new NumberObject(4, 40)
        };
        return numberObjects;

    }
}
