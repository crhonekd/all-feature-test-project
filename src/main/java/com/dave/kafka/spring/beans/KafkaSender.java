package com.dave.kafka.spring.beans;

import com.dave.kafka.spring.beans.request.DataRequest;
import com.dave.kafka.spring.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaSender {

    void send(String topic, String payload);

    void sendPerson(String topic, Person payload) throws Exception;

    void sendRequest(String topic, DataRequest payload) throws Exception;
}
