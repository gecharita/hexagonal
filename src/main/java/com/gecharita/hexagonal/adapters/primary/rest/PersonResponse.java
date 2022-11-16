package com.gecharita.hexagonal.adapters.primary.rest;

import com.gecharita.hexagonal.core.domain.Person;

public class PersonResponse {
    private Person person;

    public PersonResponse(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

}

