package com.gecharita.anemic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int phone;
    private String address;
    private String country;
    private int age;
}
