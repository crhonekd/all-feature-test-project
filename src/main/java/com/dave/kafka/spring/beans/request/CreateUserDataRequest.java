package com.dave.kafka.spring.beans.request;

import com.dave.kafka.spring.model.Person;

public class CreateUserDataRequest implements DataRequest{
    private Person person;

    public CreateUserDataRequest() {}

    public CreateUserDataRequest(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void process() {

    }
}
