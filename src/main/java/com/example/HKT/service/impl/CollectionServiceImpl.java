package com.example.HKT.service.impl;

import com.example.HKT.DTOs.PersonDto;
import com.example.HKT.service.CollectionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Override
    public List<Integer> printEven(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        return evenNumbers;
    }

    @Override
    public List<String> filterString(){
        List<String> stringList = Arrays.asList("ram", "Krishna", "Govinda", "murari", "gopal");
        List<String> filteredString = stringList.stream().filter(str -> str.length() > 3).collect(Collectors.toList());

        return filteredString;
    }

    @Override
    public List<PersonDto> validPersons(){
        List<PersonDto> people = Arrays.asList(
                new PersonDto("hare", 23, 23.4f),
                new PersonDto("Krishna", 26, 14.2f),
                new PersonDto("Ram", 26, 13.2f),
                new PersonDto("Govinda", 26, 12.6f)
        );

        List<PersonDto> persons = people.stream().filter(person -> person.getAge() > 24).collect(Collectors.toList());
        return persons;
    }
}
