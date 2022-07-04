package com.gecharita.hexagonal.infrastructure.config;

import com.gecharita.AnemicApplication;
import com.gecharita.hexagonal.domain.repository.PersonRepository;
import com.gecharita.hexagonal.domain.service.PersonService;
import com.gecharita.hexagonal.domain.service.DomainPersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AnemicApplication.class)
public class BeanConfig {
    @Bean
    PersonService personService(final PersonRepository personRepository) {
        return new DomainPersonService(personRepository);
    }
}
