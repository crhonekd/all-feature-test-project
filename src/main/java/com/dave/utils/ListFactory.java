package com.dave.utils;

import com.dave.model.Address;
import com.dave.model.Department;
import com.dave.model.Employee;
import com.dave.model.Person;
import com.gs.collections.impl.list.mutable.FastList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 06/03/2017.
 */
public class ListFactory {
    public static List<Person> getListOfPersons() {

        Department d1 =  new Department();
        d1.setName("Finance");
        d1.setDepartmentId(1);

        Address add1 = new Address();
        add1.setCity("Prague");
        add1.setHouseNumber(323);
        add1.setPostcode("150 00");

        Employee p1 = new Employee();
        p1.setFirstName("David");
        p1.setLastName("Crhonek");
        p1.setAge(34);
        p1.setAddress(add1);
        p1.setDepartment(d1);

        Address add2 = new Address();
        add2.setCity("London");
        add2.setHouseNumber(23);
        add2.setPostcode("M15 00");

        Employee p2 = new Employee();
        p2.setFirstName("John");
        p2.setLastName("Smith");
        p2.setAge(23);
        p2.setAddress(add2);
        p2.setDepartment(d1);

        Address add3 = new Address();
        add3.setCity("Prague");
        add3.setHouseNumber(12);
        add3.setPostcode("130 00");

        Employee p3 = new Employee();
        p3.setFirstName("Jana");
        p3.setLastName("Mala");
        p3.setAge(53);
        p3.setAddress(add3);
        p3.setDepartment(d1);

        List<Person> list = new ArrayList<Person>();

        list.add(p1);
        list.add(p2);
        list.add(p3);

        return list;
    }

}



