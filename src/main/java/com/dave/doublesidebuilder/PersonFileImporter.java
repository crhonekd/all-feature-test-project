package com.dave.doublesidebuilder;

public class PersonFileImporter implements Person.Importer {

    public PersonFileImporter() {
    }

    @Override
    public String getName() {
        return "David";
    }

    @Override
    public String getAddress() {
        return "Olgy Havlove 2901";
    }

    @Override
    public String getAge() {
        return "35";
    }
}
