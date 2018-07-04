package com.dave.kafka.spring.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface JsonMapper<T> {

    String objectToJson(T object) throws Exception;

    T jsonToObject(String json, Class clazz) throws Exception;
}
