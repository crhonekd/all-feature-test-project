package com.dave.model;

/**
 * Created by David on 06/03/2017.
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
