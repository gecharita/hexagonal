package com.gecharita.hexagonal.core.domain;

import com.gecharita.hexagonal.core.inport.PersonInPort;
import com.gecharita.hexagonal.core.outport.PersonOutPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonLogic implements PersonInPort {

    private final PersonOutPort personOutPort;

    public PersonLogic(PersonOutPort personOutPort){
        this.personOutPort = personOutPort;
    };

    @Override
    public List<Person> getPersons() {
        return personOutPort.findAll();
    }

    @Override
    public Person getFirstPerson() {
        List<Person> personList = personOutPort.findAll();
        return personList.isEmpty() ? null : personList.get(0) ;
    }

    @Override
    public Person save(Person person) {
        return personOutPort.save(person);
    }
}
