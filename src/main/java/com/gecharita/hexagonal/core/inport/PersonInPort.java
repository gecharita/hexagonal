package com.gecharita.hexagonal.core.inport;

import com.gecharita.hexagonal.core.domain.Person;
import java.util.List;

public interface PersonInPort {
    List<Person> getPersons();

    Person getFirstPerson();

    Person save(Person person);
}
