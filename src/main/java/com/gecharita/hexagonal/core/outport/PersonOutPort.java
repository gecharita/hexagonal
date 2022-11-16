package com.gecharita.hexagonal.core.outport;

import com.gecharita.hexagonal.core.domain.Person;

import java.util.List;

public interface PersonOutPort {

    List<Person> findAll();

    Person save(Person person);
}
