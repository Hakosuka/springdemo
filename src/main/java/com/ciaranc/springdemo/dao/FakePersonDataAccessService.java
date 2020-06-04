package com.ciaranc.springdemo.dao;

import com.ciaranc.springdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao") //matches the PersonDao in the PersonService constructor
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> peopleDB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        peopleDB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople(){
        return peopleDB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return peopleDB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> condemnedPerson = selectPersonById(id);
        if(condemnedPerson.isEmpty()) return 0;
        peopleDB.remove(condemnedPerson.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person personToBeUpdated) {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = peopleDB.indexOf(personToBeUpdated);
                    if(indexOfPersonToUpdate >= 0){
                        peopleDB.set(indexOfPersonToUpdate, personToBeUpdated);
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
