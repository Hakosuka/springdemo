package com.ciaranc.springdemo.service;

import com.ciaranc.springdemo.dao.PersonDao;
import com.ciaranc.springdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
