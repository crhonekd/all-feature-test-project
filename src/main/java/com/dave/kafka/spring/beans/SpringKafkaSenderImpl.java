package com.dave.kafka.spring.beans;

import com.dave.kafka.spring.beans.request.DataRequest;
import com.dave.kafka.spring.mapper.JsonMapper;
import com.dave.kafka.spring.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class SpringKafkaSenderImpl implements KafkaSender {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringKafkaSenderImpl.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private JsonMapper<Person> mapper;
    @Autowired
    private JsonMapper<DataRequest> reqMapper;

    @Autowired
    public SpringKafkaSenderImpl(KafkaTemplate<String, String> kafkaTemplate, JsonMapper<Person> mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    @Override
    public void send(String topic, String payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }

    @Override
    public void sendPerson(String topic, Person payload) throws Exception {
        String json = mapper.objectToJson(payload);
        LOGGER.info("sending payload='{}' to topic='{}'", json, topic);
        kafkaTemplate.send(topic, json);
    }

    @Override
    public void sendRequest(String topic, DataRequest payload) throws Exception {
        String json = reqMapper.objectToJson(payload);
        LOGGER.info("sending payload='{}' to topic='{}'", json, topic);
        kafkaTemplate.send(topic, json);
    }
}
