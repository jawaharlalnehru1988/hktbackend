package com.example.HKT.service;

import com.example.HKT.entity.Person;
import com.example.HKT.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
     private PersonRepository personRepository;

    public List<Person> getAllPersons(){
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream().map(this::addedCountryCodeOnEach).collect(Collectors.toList());
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person person){
        String phoneNumber = person.getPhone();
        if(!phoneNumber.startsWith("+91")){
            phoneNumber = "+91 "+phoneNumber;
        }
        person.setPhone(phoneNumber);
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

    private Person addedCountryCodeOnEach(Person person){
        if(person !=null){
            person.setPhone(addCountryCode(person.getPhone()));
        }
        return person;
    }

    private String addCountryCode(String phoneNumber){
        if(phoneNumber != null && !phoneNumber.startsWith("+91")){
            phoneNumber = "+91 "+phoneNumber;
        }
        return phoneNumber;
    }
}
