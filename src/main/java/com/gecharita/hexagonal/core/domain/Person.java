package com.gecharita.hexagonal.core.domain;

import java.util.Calendar;

public class Person {
    private Long id;
    private String name;
    private int phone;
    private String address;
    private String country;
    private int age;

    private int yearOfBirth;

    private Person() {}

    public Person(Long id, String name, int phone, String address, String country, int age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.country = country;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public int getYearOfBirth() {
        return Calendar.getInstance().get(Calendar.YEAR) - age;
    }
}


