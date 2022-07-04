package com.gecharita.hexagonal.application.web.rest;

import com.gecharita.anemic.dto.PersonDTO;
import com.gecharita.anemic.mapper.PersonMapper;
import com.gecharita.hexagonal.application.request.CreatePersonRequest;
import com.gecharita.hexagonal.application.response.CreatePersonResponse;
import com.gecharita.hexagonal.domain.Person;
import com.gecharita.hexagonal.infrastructure.repository.mysql.PersonEntity;
import com.gecharita.hexagonal.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PersonController(PersonService personService){
        this.personService = personService;
    }

//    @GetMapping()
//    public ResponseEntity<List<PersonDTO>> getAll(){
//        LOGGER.info("getAll");
//        List<PersonEntity> personList = personService.findAll();
//        List<PersonDTO> personDTOList = personList.stream().map(personMapper::toPersonDTO).collect(Collectors.toList());
//        return  ResponseEntity.ok(personDTOList);
//    }

    @PostMapping("")
    public ResponseEntity<CreatePersonResponse> createPerson(@RequestBody CreatePersonRequest createPersonRequest){
        LOGGER.info("createPerson");
        Person person = personService.save(createPersonRequest.getPerson());
        CreatePersonResponse createPersonResponse = new CreatePersonResponse(person);
        return ResponseEntity.ok(createPersonResponse);
    }

//    @GetMapping("/getFirst")
//    public ResponseEntity<PersonDTO> getFirst(){
//        LOGGER.info("getFirst");
//        PersonEntity person = personService.findFirst();
//        PersonDTO personDTO = personMapper.toPersonDTO(person);
//        return ResponseEntity.ok(personDTO);
//    }


}
