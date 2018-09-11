package com.dave.lombok;

public class Test {

    public static void main(String[] args) {
        Builders builders = new Builders();


        Person dave = builders.person()
                .firstName("Dav")
                .lastName("Crh")
                .address(builders.address().city("Prague").houseNumber(23).postcode("KHG KK").build())
                .build();

        System.out.println(dave);
    }
}
