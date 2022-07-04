package com.gecharita.hexagonal.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gecharita.hexagonal.domain.Person;

public class CreatePersonRequest {

    private Person person;

    public CreatePersonRequest(@JsonProperty("person") final Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

}

