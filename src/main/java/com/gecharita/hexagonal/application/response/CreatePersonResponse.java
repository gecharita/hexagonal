package com.gecharita.hexagonal.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gecharita.hexagonal.domain.Person;

public class CreatePersonResponse {
    private Person person;

    public CreatePersonResponse(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

}

