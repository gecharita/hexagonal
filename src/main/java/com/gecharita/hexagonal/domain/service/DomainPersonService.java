package com.gecharita.hexagonal.domain.service;

import com.gecharita.hexagonal.domain.Person;
import com.gecharita.hexagonal.domain.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DomainPersonService implements PersonService {

    private final PersonRepository personRepository;

    public DomainPersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    };

    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(personRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Person findFirst() {
        return personRepository.findAll().iterator().next();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
