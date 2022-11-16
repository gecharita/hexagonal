package com.gecharita.hexagonal.adapters.secondary.config;

import com.gecharita.DDDApplication;
import com.gecharita.hexagonal.core.outport.PersonOutPort;
import com.gecharita.hexagonal.core.inport.PersonInPort;
import com.gecharita.hexagonal.core.domain.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DDDApplication.class)
public class BeanConfig {
    @Bean
    PersonInPort personInPort(final PersonOutPort personOutPort) {
        return new PersonService(personOutPort);
    }
}
