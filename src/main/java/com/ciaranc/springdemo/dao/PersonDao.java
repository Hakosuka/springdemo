package com.ciaranc.springdemo.dao;

import com.ciaranc.springdemo.model.Person;

import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID newId = UUID.randomUUID();
        return insertPerson(newId, person);
    }
}
