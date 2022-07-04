package com.gecharita.hexagonal.domain.repository;

import com.gecharita.hexagonal.domain.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findAll();

    Person save(Person person);
}
