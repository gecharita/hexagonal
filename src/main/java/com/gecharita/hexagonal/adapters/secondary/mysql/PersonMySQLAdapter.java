package com.gecharita.hexagonal.adapters.secondary.mysql;

import com.gecharita.hexagonal.core.domain.Person;
import com.gecharita.hexagonal.core.outport.PersonOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//@Component
//@Primary
public class PersonMySQLAdapter implements PersonOutPort {

    @Autowired
    private PersonRepository personRepository;

    public PersonMySQLAdapter() {

    }
    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(
                personRepository.findAll().spliterator(),false)
                .map(PersonEntity::toPerson)
                .collect(Collectors.toList()
        );
    }

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = new PersonEntity(person);
        personEntity = this.personRepository.save(personEntity);
        return personEntity.toPerson();
    }
}
