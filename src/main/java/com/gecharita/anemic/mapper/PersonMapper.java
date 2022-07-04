package com.gecharita.anemic.mapper;

import com.gecharita.anemic.dto.PersonDTO;
import com.gecharita.anemic.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toPerson(PersonDTO personDTO);

    PersonDTO toPersonDTO(Person person);

}
