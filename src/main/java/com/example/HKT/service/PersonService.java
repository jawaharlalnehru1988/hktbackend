package com.example.HKT.service;

import com.example.HKT.entity.Person;
import com.example.HKT.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PersonService {

    @Autowired
     private PersonRepository personRepository;

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(int id, Person personDetails){
        Person person = personRepository.findById(id).orElse(null);

        if(person !=null){
            person.setPhone(personDetails.getPhone());
            person.setAge(personDetails.getAge());
            person.setPersonType(personDetails.getPersonType());
            return personRepository.save(person);
        }
        return null;
    }
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }
}
