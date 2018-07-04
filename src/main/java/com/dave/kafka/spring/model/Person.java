package com.dave.kafka.spring.model;

public class Person{

    private Address address;
    private Name name;
    private int age;

    public Person() {}

    public Person(Address address, Name name, int age) {
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
