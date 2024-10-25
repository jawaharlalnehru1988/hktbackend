package com.example.HKT.controller;

import com.example.HKT.DTOs.NumberObject;
import com.example.HKT.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/krishna")
public class Todos {
    @Autowired
    private TodosService todosService;
    @GetMapping()
    public String getKrishnaMessage(){
        return todosService.getKrishnaMessage();
    }

    @GetMapping("/number")
    public int getNumber(){
        return todosService.getNumber();
    }

    @GetMapping("/numarr")
    public int[] getNumArr(){
        return todosService.getNumbersArray();
    }

    @GetMapping("/numObj")
    public NumberObject[] getNumberObj(){
        return todosService.getNumberObjectsArray();
    }
}
