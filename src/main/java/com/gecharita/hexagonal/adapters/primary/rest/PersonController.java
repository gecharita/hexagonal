package com.gecharita.hexagonal.adapters.primary.rest;

import com.gecharita.hexagonal.core.domain.Person;
import com.gecharita.hexagonal.core.inport.PersonInPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName()) ;
    private final PersonInPort personInPort;
    public PersonController(PersonInPort personInPort){
        this.personInPort = personInPort;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAll(){
        LOGGER.info("getAll");
        List<Person> persons = personInPort.getPersons();
        return  ResponseEntity.ok(persons);
    }

    @PostMapping("")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest){
        LOGGER.info("createPerson");
        Person person = personInPort.save(personRequest.getPerson());
        PersonResponse createPersonResponse = new PersonResponse(person);
        return ResponseEntity.ok(createPersonResponse);
    }

}
