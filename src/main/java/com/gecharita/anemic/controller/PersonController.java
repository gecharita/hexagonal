package com.gecharita.anemic.controller;

import com.gecharita.anemic.dto.PersonDTO;
import com.gecharita.anemic.mapper.PersonMapper;
import com.gecharita.anemic.model.Person;
import com.gecharita.anemic.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName()) ;
    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper){
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getAll(){
        LOGGER.info("getAll");
        List<Person> personList = personService.findAll();
        List<PersonDTO> personDTOList = personList.stream().map(personMapper::toPersonDTO).collect(Collectors.toList());
        return  ResponseEntity.ok(personDTOList);
    }

    @PostMapping("")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO){
        LOGGER.info("createPerson");
        Person person = personMapper.toPerson(personDTO);
        person = personService.save(person);
        return ResponseEntity.ok(personMapper.toPersonDTO(person));
    }

    @GetMapping("/getFirst")
    public ResponseEntity<PersonDTO> getFirst(){
        LOGGER.info("getFirst");
        Person person = personService.findFirst();
        PersonDTO personDTO = personMapper.toPersonDTO(person);
        return ResponseEntity.ok(personDTO);
    }


}
