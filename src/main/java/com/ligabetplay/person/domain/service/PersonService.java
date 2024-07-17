package com.ligabetplay.person.domain.service;

import java.util.List;
import java.util.Optional;

import com.ligabetplay.person.domain.entity.Person;

public interface PersonService {
    void cratePerson(Person person);
    void updatePerson(Person person);
    Optional<Person> deletePerson(String id);
    Optional <Person> findPersonById(String id);
    List<Person> findAllPerson();
}
