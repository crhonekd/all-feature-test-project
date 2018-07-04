package com.dave.kafka.spring.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Jackson2JsonMapper<T> implements JsonMapper<T> {

    private ObjectMapper mapper = new ObjectMapper();
    private Class<T> type;

    @Override
    public String objectToJson(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    @Override
    public T jsonToObject(String json, Class clazz) throws IOException {
        return mapper.readValue(json, (Class<T>) clazz);
    }
}
