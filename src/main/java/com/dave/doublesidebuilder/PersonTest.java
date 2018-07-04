package com.dave.doublesidebuilder;

public class PersonTest {

    public static void main(String[] args) {
         Person p  = new Person(new PersonFileImporter());

        Person.Exporter exporter = new PersonFileExporter();
        p.export(exporter);

        System.out.println();



        }
}
