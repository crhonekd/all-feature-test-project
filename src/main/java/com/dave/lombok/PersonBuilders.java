package com.dave.lombok;

import com.dave.model.Address;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

public class PersonBuilders {

    @Builder(builderMethodName = "person")
    private Person createPerson( String firstName, String lastName, String middleName, int age, @Singular List<Address> addresses) {
        return new Person(firstName, lastName, middleName, age, addresses);
    }
}
