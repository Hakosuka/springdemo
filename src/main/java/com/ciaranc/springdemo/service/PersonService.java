package com.ciaranc.springdemo.service;

import com.ciaranc.springdemo.dao.PersonDao;
import com.ciaranc.springdemo.model.Person;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao){
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
