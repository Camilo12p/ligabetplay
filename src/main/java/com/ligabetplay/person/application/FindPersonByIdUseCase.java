package com.ligabetplay.person.application;

import java.util.Optional;

import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.service.PersonService;

public class FindPersonByIdUseCase {
    PersonService   personService ;

    public FindPersonByIdUseCase(PersonService personService){
        this.personService = personService;
    } 

    public Optional<Person> execute(String id){
        return personService.findPersonById(id);
    }

}
