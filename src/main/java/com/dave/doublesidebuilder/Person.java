package com.dave.doublesidebuilder;

public class Person {

    private Name name;
    private Address address;
    private int age;

    public static interface Exporter {
        void storeName(String name);
        void storetAddress(String address);
        void storeAge(String age);
    }

    public interface Importer {
        String getName();
        String getAddress();
        String getAge();
    }

    public Person(Person.Importer importer) {
        this.name = new Name(importer.getName());
        this.address = new Address(importer.getAddress());
        this.age = Integer.parseInt(importer.getAge());
    }

    public void export(Person.Exporter exporter) {
        exporter.storetAddress(this.name.toString());
        exporter.storeName(this.name.toString());
        exporter.storeAge(String.valueOf(this.age));
    }



}
