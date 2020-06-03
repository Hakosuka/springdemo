package com.ciaranc.springdemo.dao;

import com.ciaranc.springdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao") //matches the PersonDao in the PersonService constructor
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> peopleDB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        peopleDB.add(new Person(id, person.getName()));
        return 1;
    }
}
