package com.gecharita.hexagonal.adapters.primary.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gecharita.hexagonal.core.domain.Person;

public class PersonRequest {

    private Person person;

    public PersonRequest(@JsonProperty("person") final Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

}

