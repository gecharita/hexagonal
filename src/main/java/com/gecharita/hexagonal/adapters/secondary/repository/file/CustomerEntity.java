package com.gecharita.hexagonal.adapters.secondary.repository.file;

import com.gecharita.hexagonal.core.domain.Person;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerEntity implements Serializable {
    private Long id;
    private String name;
    private int phone;
    private String address;
    private String country;
    private int age;

    public CustomerEntity(){ }

    public CustomerEntity(Person person){
        this.name = person.getName();
        this.phone = person.getPhone();
        this.address = person.getAddress();
        this.country = person.getCountry();
        this.age = person.getAge();
    }

    public Person toPerson(){
        return new Person(this.id, this.name, this.phone, this.address, this.country, this.age);

    }
}
