package com.gecharita.hexagonal.adapters.primary.console;

import com.gecharita.DDDApplication;
import com.gecharita.hexagonal.core.domain.Person;
import com.gecharita.hexagonal.core.inport.PersonInPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.logging.Logger;

@Component
public class PersonConsole implements CommandLineRunner {

    private static final Logger LOG = Logger.getLogger(DDDApplication.class.getName()) ;

    private final PersonInPort personInPort;
    public PersonConsole(PersonInPort personInPort){
        this.personInPort = personInPort;
    }

    public void create(String name, String address, int age){
        Person person = new Person(null, name, 0, address, null, age);
        this.personInPort.save(person);
    }

    @Override
	public void run(String... args) throws Exception {
        System.out.println("**** Enter person (name-address-age) ****");
        try (Scanner scanner = new Scanner(System.in)) {
            String personData = scanner.nextLine();
            LOG.info(personData);
            String[] fields = personData.split("-");
            String name = fields[0];
            String address = fields[1];
            String age = fields[2];
            this.create(name, address, Integer.parseInt(age));
        }
    }
}
