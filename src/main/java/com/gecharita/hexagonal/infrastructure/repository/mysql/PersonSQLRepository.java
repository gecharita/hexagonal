package com.gecharita.hexagonal.infrastructure.repository.mysql;

import com.gecharita.hexagonal.domain.Person;
import com.gecharita.hexagonal.domain.repository.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Primary
public class PersonSQLRepository implements PersonRepository {

    private final SpringDataPersonSQLRepository personRepository;

    public PersonSQLRepository(final SpringDataPersonSQLRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(
                personRepository.findAll().spliterator(),false)
                .map(PersonEntity::toPerson)
                .collect(Collectors.toList()
        );
    }

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = new PersonEntity(person);
        personEntity = this.personRepository.save(personEntity);
        return personEntity.toPerson();
    }
}
