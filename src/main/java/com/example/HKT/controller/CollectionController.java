package com.example.HKT.controller;

import com.example.HKT.DTOs.PersonDto;
import com.example.HKT.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/evenNumber")
    public ResponseEntity<List<Integer>> getEvenNumber() {
            List<Integer> evenNumber = collectionService.printEven();
            return new ResponseEntity<>(evenNumber, HttpStatus.OK);
    }
    @GetMapping("/validNames")
    public ResponseEntity<List<String>> getMinString(){
        List<String> minNumbers = collectionService.filterString();
        return new ResponseEntity<>(minNumbers, HttpStatus.OK);
    }

    @GetMapping("/validPeople")
    public ResponseEntity<List<PersonDto>> getPeople(){
        List<PersonDto> persons = collectionService.validPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/filterNull")
    public List<String> getWorkers(){
        List<String> words = Arrays.asList("hello", "", null, "world", "Java", "");

        // Filtering out null or empty strings
        List<String> nonEmptyWords = words.stream()
                .filter(word -> word != null && !word.isEmpty())
                .collect(Collectors.toList());
        return  nonEmptyWords;
    }

    @GetMapping("/multipleFilter")
    public List<Integer> getMultiple(){
         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> num = numbers.stream().filter(n -> n%2 == 0 && n > 5).collect(Collectors.toList());
        return num;
    }

    @GetMapping("/squareNum")
    public List<Integer> getSquare(){
        List<Integer> sqNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> sqNumber = sqNum.stream().map(n -> n*n).collect(Collectors.toList());
        return sqNumber;
    }

    @GetMapping("/arrayadd")
    public ArrayList<String> getFruit(){
     ArrayList<String> fruit = new ArrayList<String>();
     fruit.add("Apple");
     fruit.add("Banana");
     fruit.add("Carret");
     fruit.add("Dolpy");

     ArrayList<String> fruits2 = new ArrayList<String>();
     fruits2.add( "Guava");
     fruits2.add( "Orange");
     fruits2.add("Cherry");
     fruits2.addAll(fruit);


     return fruits2;

    }
}
