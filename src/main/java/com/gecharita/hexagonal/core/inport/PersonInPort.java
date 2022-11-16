package com.gecharita.hexagonal.core.inport;

import com.gecharita.hexagonal.core.domain.Person;
import java.util.List;

public interface PersonInPort {
    List<Person> findAll();

    Person findFirst();

    Person save(Person person);
}
