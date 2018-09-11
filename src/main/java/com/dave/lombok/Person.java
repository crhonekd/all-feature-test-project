package com.dave.lombok;

import com.dave.model.Address;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private List<Address> addresses;

    public void sayHi() {
        System.out.println(firstName + " says hi...");
        log.info("Hello");
    }

}
