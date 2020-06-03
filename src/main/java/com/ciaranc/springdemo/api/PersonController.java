package com.ciaranc.springdemo.api;

import com.ciaranc.springdemo.model.Person;
import com.ciaranc.springdemo.service.PersonService;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
