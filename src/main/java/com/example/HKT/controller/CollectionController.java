package com.example.HKT.controller;

import com.example.HKT.DTOs.PersonDto;
import com.example.HKT.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
