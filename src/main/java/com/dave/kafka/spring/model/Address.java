package com.dave.kafka.spring.model;

import java.io.Serializable;

public class Address{
    private String city;
    private String code;

    public Address() {
    }

    public Address(String city, String code) {
        this.city = city;
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
