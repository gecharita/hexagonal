package com.gecharita.anemic.mapper;

import com.gecharita.anemic.dto.PersonDTO;
import com.gecharita.hexagonal.infrastructure.repository.mysql.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity toPerson(PersonDTO personDTO);

    PersonDTO toPersonDTO(PersonEntity person);

}
