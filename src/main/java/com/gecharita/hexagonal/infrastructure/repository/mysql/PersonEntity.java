package com.gecharita.hexagonal.infrastructure.repository.mysql;

import com.gecharita.hexagonal.domain.Person;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@javax.persistence.Entity
@Data
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int phone;
    private String address;
    private String country;
    private int age;

    public PersonEntity(){ }

    public PersonEntity(Person person){
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
