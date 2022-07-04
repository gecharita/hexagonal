package com.gecharita.hexagonal.domain.service;

import com.gecharita.hexagonal.domain.Person;
import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findFirst();

    Person save(Person person);
}
