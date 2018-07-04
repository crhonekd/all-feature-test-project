package com.dave.doublesidebuilder;


public class PersonFileExporter implements Person.Exporter {
    private String name;
    private String address;
    private String age;
    @Override
    public void storeName(String name) {
        this.name = name;
    }

    @Override
    public void storetAddress(String address) {
        this.address = address;
    }

    @Override
    public void storeAge(String age) {
        this.age = age;
    }

}
