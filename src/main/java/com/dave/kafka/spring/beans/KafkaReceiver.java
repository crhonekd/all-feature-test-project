package com.dave.kafka.spring.beans;

import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

public interface KafkaReceiver {

    void receive(String payload) throws Exception;
}
