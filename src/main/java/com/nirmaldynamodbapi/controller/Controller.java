package com.nirmaldynamodbapi.controller;

import com.nirmaldynamodbapi.entity.Person;
import com.nirmaldynamodbapi.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Controller {
    @Autowired
    PersonRepository repository;
    @GetMapping("/displayName")
    public String getName(){
        return "NameDisplayed";
    }
    @PostMapping("/savePerson")
    public Person savePerson (@RequestBody Person person){
        log.info("test");
        return repository.addPerson(person);
    }

    @GetMapping("/getPerson/{personId}")
    public Person findPerson(@PathVariable String personId ){
        return repository.findPersonByPersonId(personId);
    }

    @DeleteMapping("/deletePerson")
    public String deletePerson (@RequestBody Person person) {
        return repository.deletePerson(person);
    }
    @PutMapping("/editPerson")
    public String updatePerson( @RequestBody Person person){
        return repository.editPerson(person);
    }
}
