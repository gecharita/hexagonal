package com.gecharita.hexagonal.adapters;

import com.gecharita.DDDApplication;
import com.gecharita.hexagonal.adapters.secondary.file.CustomerFileAdapter;
import com.gecharita.hexagonal.adapters.secondary.mysql.PersonMySQLAdapter;
import com.gecharita.hexagonal.core.outport.PersonOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackageClasses = AdapterConfig.class)
public class AdapterConfig {

    @Bean
    @Primary
    PersonOutPort mySqlAdapter(){
        return new PersonMySQLAdapter();
    }

    @Bean
//    @Primary
    PersonOutPort fileAdapter(){
        return new CustomerFileAdapter();
    }
}
