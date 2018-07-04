package com.dave.xmlSchemaValidation.model;

import com.sun.xml.internal.txw2.annotation.XmlNamespace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by David on 04/04/2017.
 */
@XmlRootElement(name = "Person", namespace = "MyNamespace")
@XmlType(name = "", propOrder = {"firstName", "lastName", "age"})
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public int getAge() {
        return age;
    }


    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "FirstName", namespace = "MyNamespace")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "LastName", namespace = "MyNamespace")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @XmlElement(name = "Age", namespace = "MyNamespace")
    public void setAge(int age) {
        this.age = age;
    }
}
