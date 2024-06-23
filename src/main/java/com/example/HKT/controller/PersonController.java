package com.example.HKT.controller;

import com.example.HKT.entity.ApiResponse;
import com.example.HKT.entity.Person;
import com.example.HKT.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public List<Person> getAllPerson(){
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable int id){
       return personService.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Person> createPerson(@RequestBody Person person){
        Person createdPerson =  personService.createPerson(person);
        return  new ApiResponse<>("Successfully added", createdPerson);
    }

    @PutMapping("/{id}")
    public ApiResponse<Person> updatePerson(@PathVariable int id, @RequestBody Person person){
         Person updatedPerson =  personService.updatePerson(id, person);
        return new ApiResponse<>("Successfully updated", updatedPerson);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deletePerson(@PathVariable int id){
        personService.deletePerson(id);
        return new ApiResponse<>("Successfully deleted ", null);
    }
}
