package com.gecharita.hexagonal.infrastructure.repository.file;

import com.gecharita.hexagonal.domain.Person;
import com.gecharita.hexagonal.domain.repository.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class CustomerFileRepository implements PersonRepository {
    private static final String FILE = "customers.dat";
    @Override
    public List<Person> findAll() {
        return readCustomers()
                .stream()
                .map(CustomerEntity::toPerson)
                .collect(Collectors.toList());
    }

    @Override
    public Person save(Person person) {
        writeCustomers(person);
        return person;
    }

    private void writeCustomers(Person person) {
        List<CustomerEntity> customers = readCustomers();
        CustomerEntity customerEntity = new CustomerEntity(person);
        customers.add(customerEntity);
        try (FileOutputStream fos = new FileOutputStream(FILE);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(customers);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<CustomerEntity> readCustomers() {
        List<CustomerEntity> customers = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FILE);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // write object to file
            customers = (List<CustomerEntity>) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return customers;
    }
}
