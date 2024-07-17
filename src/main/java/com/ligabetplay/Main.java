package com.ligabetplay;

import java.util.Optional;

import javax.swing.JOptionPane;

import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonByIdUseCase;
import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.service.PersonService;
import com.ligabetplay.person.infrastructure.PersonRepository;
import com.ligabetplay.person.infrastructure.PersonUI;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonRepository();
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
        FindPersonByIdUseCase findByIdCase = new FindPersonByIdUseCase(personService);
        PersonUI personUI = new PersonUI(createPersonUseCase,findByIdCase);

        // personUI.crear();

        personUI.frmRegPerson();
        // Optional<Person> person = personUI.findPersonById();

        // if(person.isPresent()){
        //     JOptionPane.showMessageDialog( null, "Persona Encotrada " +
        //     person.get().getNombre());
        // }else {
        //     JOptionPane.showMessageDialog( null, "Persona no encotrada" );
        // }
        
    }
}