package com.ciaranc.springdemo.api;

import com.ciaranc.springdemo.model.Person;
import com.ciaranc.springdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
