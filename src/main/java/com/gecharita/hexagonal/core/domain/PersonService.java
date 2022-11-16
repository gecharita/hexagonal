package com.gecharita.hexagonal.core.domain;

import com.gecharita.hexagonal.core.inport.PersonInPort;
import com.gecharita.hexagonal.core.outport.PersonOutPort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PersonService implements PersonInPort {

    private final PersonOutPort personOutPort;

    public PersonService(PersonOutPort personOutPort){
        this.personOutPort = personOutPort;
    };

    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(personOutPort.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Person findFirst() {
        return personOutPort.findAll().iterator().next();
    }

    @Override
    public Person save(Person person) {
        return personOutPort.save(person);
    }
}
