package com.dave.java8;

import com.dave.model.Person;
import com.dave.utils.ListFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by David on 21/03/2017.
 */
public class ConditionsTest {

    public static void main(String[] args) {
        List<Person> listOfPersons = ListFactory.getListOfPersons();
        List<Person> peopleOverThirty = filterList((Person p) -> p.getAge() > 30, listOfPersons);
        System.out.println();
    }

    public static List<Person> filterList(Predicate<Person> p, List<? extends Person> list) {
        return list.stream()
                .filter(p)
                .collect(Collectors.toList());
    }
}
